package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.VirtualRegister;

import java.util.*;

public class FuncInlineprocess {
    private class FuncInfo{
        int numInst = 0, numused = 0;
        boolean recursivecall, memfunc = false;
    }

    private final int MAX_INLINE = 30;
    private final int MAX_LOW_INLINE = 30;
    private final int MAX_FUNC = 1 << 12;
    private final int MAX_INLINE_DEPPTH = 5;
    public IRRoot ir;
    private Map<Func, FuncInfo> funcFuncInfoMap = new HashMap<>();

    public FuncInlineprocess(IRRoot ir){
        this.ir = ir;
    }

    private void copyValue(Map<Object, Object> renameMap, Value value){
        if(renameMap.containsKey(value))
            return;
        renameMap.put(value, value.copy());
    }

    private Inst InlineProcess(FuncCallInst funcCallInst){
        Func callerFunc = funcCallInst.parentBB.func;
        Func calleeFunc = funcCallInst.func;
        List<BasicBlock> reversePostOrder = calleeFunc.getReversePostOrder();

        Map<Object, Object> renameMap = new HashMap<>();

        BasicBlock oldExitBB = calleeFunc.endBB;
        BasicBlock newExitBB = new BasicBlock(callerFunc, oldExitBB.name);
        renameMap.put(oldExitBB, newExitBB);
        renameMap.put(calleeFunc.startBB, funcCallInst.parentBB);
        if(callerFunc.endBB == funcCallInst.parentBB)
            callerFunc.endBB = newExitBB;

        Map<Object, Object> callrenameMap = Collections.singletonMap(funcCallInst.parentBB, newExitBB);
        for(Inst inst = funcCallInst.nextInst; inst != null; inst = inst.nextInst){
            if(inst instanceof JumpInst)
                newExitBB.setJumpInst(((JumpInst)inst).copyRename(callrenameMap));
            else
                newExitBB.addInst(inst.copyRename(callrenameMap));
            inst.remove();
        }
        Inst newExitBBfirstInst = newExitBB.firstInst;

        for(int i = 0; i < funcCallInst.args.size(); ++i){
            VirtualRegister oldArgReg = calleeFunc.argVRegList.get(i);
            VirtualRegister newArgReg = oldArgReg.copy();
            funcCallInst.prependInst(new MoveInst(funcCallInst.parentBB, newArgReg, funcCallInst.args.get(i)));
            renameMap.put(oldArgReg, newArgReg);
        }

        funcCallInst.remove();

        for(BasicBlock BB : reversePostOrder){
            if(!renameMap.containsKey(BB))
                renameMap.put(BB, new BasicBlock(callerFunc, BB.name));
        }

        for(BasicBlock oldBB : reversePostOrder){
            BasicBlock newBB = (BasicBlock)renameMap.get(oldBB);
            for(Inst inst = oldBB.firstInst; inst != null; inst = inst.nextInst){
                for(Value usedValue : inst.usedRegValues)
                    copyValue(renameMap, usedValue);
                if(inst.getDefinedRegister() != null)
                    copyValue(renameMap, inst.getDefinedRegister());
                if(newBB == newExitBB){
                    if(!(inst instanceof ReturnJumpInst))
                        newExitBBfirstInst.prependInst(inst.copyRename(renameMap));
                }
                else {
                    if(inst instanceof JumpInst){
                        if(!(inst instanceof ReturnJumpInst))
                            newBB.setJumpInst(((JumpInst)inst).copyRename(renameMap));
                    }
                    else
                        newBB.addInst(inst.copyRename(renameMap));
                }
            }
        }

        if(!funcCallInst.parentBB.hasJumpInit)
            funcCallInst.parentBB.setJumpInst(new JumpJumpInst(funcCallInst.parentBB, newExitBB));

        ReturnJumpInst returnJumpInst = calleeFunc.returnList.get(0);
        if(returnJumpInst.returnvalue != null)
            newExitBBfirstInst.prependInst(new MoveInst(newExitBB, funcCallInst.dest, (Value)renameMap.get(returnJumpInst.returnvalue)));

        return newExitBB.firstInst;
    }

    public void process(){
        for(Func func : ir.funcs.values()){
            func.recursiveCall = func.calleeSet.contains(func);
            FuncInfo funcInfo = new FuncInfo();
            funcInfo.recursivecall = func.recursiveCall;
            funcInfo.memfunc = func.isMemFunc;
            funcFuncInfoMap.put(func, funcInfo);
        }
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            for(BasicBlock BB : func.getReversePostOrder()){
                for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                    funcInfo.numInst ++;
                    if(inst instanceof FuncCallInst){
                        FuncInfo calleeInfo = funcFuncInfoMap.get(((FuncCallInst)inst).func);
                        if(calleeInfo != null)
                            calleeInfo.numused ++;
                    }
                }
            }
        }
        List<BasicBlock> reversePostOrder = new ArrayList<>();
        List<String> uncalledFunc = new ArrayList<>();

        boolean changed = true, thisFuncchanged;
        while(changed){
            changed = false;
            uncalledFunc.clear();
            for(Func func : ir.funcs.values()){
                FuncInfo funcInfo = funcFuncInfoMap.get(func);
                reversePostOrder.clear();
                reversePostOrder.addAll(func.getReversePostOrder());
                thisFuncchanged = false;
                for(BasicBlock BB : reversePostOrder){
                    for(Inst inst = BB.firstInst, nextInst; inst != null; inst = nextInst){
                        nextInst = inst.nextInst;
                        if(!(inst instanceof FuncCallInst))//not a function call
                            continue;
                        FuncInfo calleeInfo = funcFuncInfoMap.get(((FuncCallInst)inst).func);
                        if(calleeInfo == null)//no callee function
                            continue;
                        if(calleeInfo.recursivecall)// a recursive function
                            continue;
                        if(calleeInfo.memfunc)
                            continue;
                        if(calleeInfo.numInst > MAX_LOW_INLINE || calleeInfo.numInst + funcInfo.numInst > MAX_FUNC)//the callee function is too big
                            continue;
                        nextInst = InlineProcess((FuncCallInst)inst);
                        funcInfo.numInst += calleeInfo.numInst;
                        changed = true;
                        thisFuncchanged = true;
                    }
                }
                if(thisFuncchanged)
                    func.calcReversePostOrder();
            }
        }
        for(Func func : ir.funcs.values()){
            func.updateCalleeSet();
        }
        ir.updateCalleeSet();
    }
}
