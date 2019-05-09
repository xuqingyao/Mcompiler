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

    // return newEndBB.firstInst
    private Inst InlineProcess(FuncCallInst funcCallInst){
        Func callerFunc = funcCallInst.parentBB.func;
        Func calleeFunc = funcCallInst.func;
        List<BasicBlock> reversePostOrder = calleeFunc.getReversePostOrder();

        Map<Object, Object> renameMap = new HashMap<>();

        //create start and end BB
        BasicBlock oldEndBB = calleeFunc.endBB;
        BasicBlock newEndBB = new BasicBlock(callerFunc, oldEndBB.name);
        renameMap.put(oldEndBB, newEndBB);
        renameMap.put(calleeFunc.startBB, funcCallInst.parentBB);
        if(callerFunc.endBB == funcCallInst.parentBB)
            callerFunc.endBB = newEndBB;

        //move inst after funcCallInst to the newEndBB
        Map<Object, Object> callrenameMap = Collections.singletonMap(funcCallInst.parentBB, newEndBB);
        for(Inst inst = funcCallInst.nextInst; inst != null; inst = inst.nextInst){
            if(inst instanceof JumpInst)
                newEndBB.setJumpInst(((JumpInst)inst).copyRename(callrenameMap));
            else
                newEndBB.addInst(inst.copyRename(callrenameMap));
            inst.remove();
        }
        Inst newEndBBfirstInst = newEndBB.firstInst;

        //set up arguments
        for(int i = 0; i < funcCallInst.args.size(); ++i){
            VirtualRegister oldArgReg = calleeFunc.argVRegList.get(i);
            VirtualRegister newArgReg = oldArgReg.copy();
            funcCallInst.prependInst(new MoveInst(funcCallInst.parentBB, newArgReg, funcCallInst.args.get(i)));
            renameMap.put(oldArgReg, newArgReg);
        }

        //remove functCallInst
        funcCallInst.remove();

        //copy blocks
        for(BasicBlock BB : reversePostOrder){
            if(!renameMap.containsKey(BB))
                renameMap.put(BB, new BasicBlock(callerFunc, BB.name));
        }

        //copy Insts
        for(BasicBlock oldBB : reversePostOrder){
            BasicBlock newBB = (BasicBlock)renameMap.get(oldBB);
            for(Inst inst = oldBB.firstInst; inst != null; inst = inst.nextInst){
                for(Value usedValue : inst.usedRegValues)
                    copyValue(renameMap, usedValue);
                if(inst.getDefinedRegister() != null)
                    copyValue(renameMap, inst.getDefinedRegister());
                if(newBB == newEndBB){
                    if(!(inst instanceof ReturnJumpInst))
                        newEndBBfirstInst.prependInst(inst.copyRename(renameMap));
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

        //check the jumpinst
        if(!funcCallInst.parentBB.hasJumpInit)
            funcCallInst.parentBB.setJumpInst(new JumpJumpInst(funcCallInst.parentBB, newEndBB));

        //copy return value
        ReturnJumpInst returnJumpInst = calleeFunc.returnList.get(0);
        if(returnJumpInst.returnvalue != null)
            newEndBBfirstInst.prependInst(new MoveInst(newEndBB, funcCallInst.dest, (Value)renameMap.get(returnJumpInst.returnvalue)));

        return newEndBB.firstInst;
    }

    private void countInstNum(){
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
    }

    public void process(){
        for(Func func : ir.funcs.values()){
            func.recursiveCall = func.calleeSet.contains(func);
            FuncInfo funcInfo = new FuncInfo();
            funcInfo.recursivecall = func.recursiveCall;
            funcInfo.memfunc = func.isMemFunc;
            funcFuncInfoMap.put(func, funcInfo);
        }

        countInstNum();

        List<BasicBlock> reversePostOrder;
        List<String> uncalledFunc = new ArrayList<>();
        boolean changed = true, thisFuncchanged;
        while(changed){
            changed = false;
            uncalledFunc.clear();
            for(Func func : ir.funcs.values()){
                FuncInfo funcInfo = funcFuncInfoMap.get(func);
                reversePostOrder = new ArrayList<>(func.getReversePostOrder());
                thisFuncchanged = false;
                for(BasicBlock BB : reversePostOrder){
                    for(Inst inst = BB.firstInst, nextInst; inst != null; inst = nextInst){
                        nextInst = inst.nextInst;
                        if(!(inst instanceof FuncCallInst))//not a function call, skip
                            continue;
                        FuncInfo calleeInfo = funcFuncInfoMap.get(((FuncCallInst)inst).func);
                        if(calleeInfo == null)//a builtIn func, skip
                            continue;
                        if(calleeInfo.recursivecall)// a recursive function, skip
                            continue;
                        if(calleeInfo.memfunc)
                            continue;
                        if(calleeInfo.numInst > 30 || calleeInfo.numInst + funcInfo.numInst > 1 << 12)//the callee function is too big
                            continue;
                        nextInst = InlineProcess((FuncCallInst)inst);//the newEndBB.firstInstz
                        funcInfo.numInst += calleeInfo.numInst;
                        changed = true;
                        thisFuncchanged = true;
                        if(--calleeInfo.numused == 0)
                            uncalledFunc.add(((FuncCallInst) inst).func.name);
                    }
                }
                if(thisFuncchanged)
                    func.calcReversePostOrder();
            }
            for(String name : uncalledFunc)
                ir.removeFunc(name);
        }
        for(Func func : ir.funcs.values())
            func.updateCalleeSet();
        ir.updateCalleeSet();
    }
}
