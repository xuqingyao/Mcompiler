package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;

import java.util.*;

import static com.echo.compiler.NASM.NASMRegisterSet.*;

//push caller save register and argument into the stack
//push rbp into the stack, move the value of rsp to rbp, push callee save into the stack
//reduce rbp, alloc stack frame of function
//recover callee after the call, set rsp as rbp, recover rbp to the old value
//clear the argument in the stack

public class NASMTransformer {
    private class FuncInfo{
        int ExtraArgNum = 0, StackSlotNum = 0;
        List<PhysicalRegister> usedCallerSaveReg = new ArrayList<>();
        List<PhysicalRegister> usedCalleeSaveReg = new ArrayList<>();
        Set<PhysicalRegister> recursiveUsedReg = new HashSet<>();
        Map<StackSlot, Integer> stackSlotOffsetMap = new HashMap<>();
    }

    public IRRoot ir;

    public NASMTransformer(IRRoot ir){
        this.ir = ir;
    }

    private Map<Func, FuncInfo> funcFuncInfoMap = new HashMap<>();

    private void calcFrame(){
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = new FuncInfo();
            for(PhysicalRegister physicalRegister : func.usedPhysicalGeneralRegs){
                if(physicalRegister.isCalleeSave())
                    funcInfo.usedCalleeSaveReg.add(physicalRegister);
                if(physicalRegister.isCallerSave())
                    funcInfo.usedCallerSaveReg.add(physicalRegister);
            }
            funcInfo.usedCalleeSaveReg.add(rbx);
            funcInfo.usedCallerSaveReg.add(rbp);

            funcInfo.StackSlotNum = func.stackSlots.size();
            for(int i = 0; i < funcInfo.StackSlotNum; ++ i)
                funcInfo.stackSlotOffsetMap.put(func.stackSlots.get(i), i * 8);
            if((funcInfo.usedCalleeSaveReg.size() + funcInfo.StackSlotNum) % 2 == 0) // align rsp
                funcInfo.StackSlotNum ++;

            funcInfo.ExtraArgNum = (func.argVRegList.size() - 6) <= 0 ? 0 : func.argVRegList.size() - 6;

            int extraArgOffset = (funcInfo.usedCalleeSaveReg.size() + funcInfo.StackSlotNum + 1) * 8;
            for(int i = 6; i < func.argVRegList.size(); ++ i, extraArgOffset += 8){
                VirtualRegister arg = func.argVRegList.get(i);
                StackSlot stackSlot = func.argsStaticSlotMap.get(arg);
                funcInfo.stackSlotOffsetMap.put(stackSlot, extraArgOffset);
            }

            funcFuncInfoMap.put(func, funcInfo);
        }
    }

    private void calcRecursiveRegUse(){
        for(Func func : ir.buildInFuncs.values())
            funcFuncInfoMap.put(func, new FuncInfo());
        for(Func func : funcFuncInfoMap.keySet()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            funcInfo.recursiveUsedReg.addAll(func.usedPhysicalGeneralRegs);
            for(Func calleeFunc : func.recursiveCalleeSet)
                funcInfo.recursiveUsedReg.addAll(calleeFunc.usedPhysicalGeneralRegs);
        }
    }

    private void processFunc(){
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            BasicBlock entryBB = func.startBB;
            processEntry(funcInfo, entryBB);
            processBody(func, funcInfo);
            processReturn(func);
            processExit(func, funcInfo, entryBB);
        }
    }

    private void processEntry(FuncInfo funcInfo, BasicBlock entryBB){
        Inst firstInst = entryBB.firstInst;
        for(PhysicalRegister physicalRegister : funcInfo.usedCalleeSaveReg)
            firstInst.prependInst(new PushInst(entryBB, physicalRegister));
        if(funcInfo.StackSlotNum > 0)
            firstInst.prependInst(new BinaryOpInst(entryBB, rsp, BinaryOpInst.BinaryOps.SUB, rsp, new IntImmValue(funcInfo.StackSlotNum * 8)));
        firstInst.prependInst(new MoveInst(entryBB, rbp, rsp));
    }

    private void processBody(Func func, FuncInfo funcInfo){
        for(BasicBlock BB : func.getReversePostOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                if(inst instanceof FuncCallInst)
                    processFuncCall((FuncCallInst)inst, func, funcInfo);
                else if(inst instanceof  HeapAllocInst)
                    processHeapAlloc((HeapAllocInst)inst, funcInfo);
                else if(inst instanceof LoadInst)
                    processLoad((LoadInst)inst, funcInfo);
                else if(inst instanceof StoreInst)
                    processStore((StoreInst)inst, funcInfo);
                else if(inst instanceof MoveInst)
                    processMove((MoveInst)inst);
            }
        }
    }

    private void processReturn(Func func){
        ReturnJumpInst returnJumpInst = func.returnList.get(0);
        if(returnJumpInst.returnvalue != null)
            returnJumpInst.prependInst(new MoveInst(returnJumpInst.parentBB, rax, returnJumpInst.returnvalue));
    }

    private void processExit(Func func, FuncInfo funcInfo, BasicBlock entryBB){
        BasicBlock exitBB = func.endBB;
        Inst lastInst = exitBB.lastInst;
        if(funcInfo.StackSlotNum > 0)
            lastInst.prependInst(new BinaryOpInst(entryBB, rsp, BinaryOpInst.BinaryOps.ADD, rsp, new IntImmValue(funcInfo.StackSlotNum * 8)));
        for(int i = funcInfo.usedCalleeSaveReg.size() - 1; i >= 0; --i)
            lastInst.prependInst(new PopInst(entryBB, funcInfo.usedCalleeSaveReg.get(i)));
    }

    private void processFuncCall(FuncCallInst inst, Func func, FuncInfo funcInfo){
        Func calleeFunc = inst.func;
        FuncInfo calleeFuncInfo = funcFuncInfoMap.get(calleeFunc);
        // push caller save registers which would be changed by callee
        int PushCallSaveNum = 0;
        for(PhysicalRegister physicalRegister : funcInfo.usedCallerSaveReg){
            if(physicalRegister.isFuncArg() && physicalRegister.getArgIdx() < func.argVRegList.size())//the register is enough
                continue;
            if(calleeFuncInfo.recursiveUsedReg.contains(physicalRegister)){
                PushCallSaveNum++;
                inst.prependInst(new PushInst(inst.parentBB, physicalRegister));
            }
        }
        // push argument registers
        int PushFuncArgRegNum = func.argVRegList.size() <= 6 ? func.argVRegList.size() : 6;
        for(int i = 0; i < PushFuncArgRegNum; ++ i)
            inst.prependInst(new PushInst(inst.parentBB, funcArg.get(i)));
        PushCallSaveNum += PushFuncArgRegNum;
        // set arguments
        boolean extraPush = false;
        List<Value> arg = inst.args;
        List<Integer> funcArgOffset = new ArrayList<>();
        Map<PhysicalRegister, Integer> funcArgOffsetMap = new HashMap<>();
        if((PushCallSaveNum + calleeFuncInfo.ExtraArgNum) % 2 == 1){//align rsp
            extraPush = true;
            inst.prependInst(new PushInst(inst.parentBB, new IntImmValue(0)));
        }
        for(int i = arg.size() - 1; i > 5; --i){
            if(arg.get(i) instanceof StackSlot){
                inst.prependInst(new LoadInst(inst.parentBB, rax, rbp, 8, funcInfo.stackSlotOffsetMap.get(arg.get(i))));
                inst.prependInst(new PushInst(inst.parentBB, rax));
            }
            else
                inst.prependInst(new PushInst(inst.parentBB, arg.get(i)));
        }

        int Offset = 0;
        for(int i = 0; i < 6; ++i){
            if(arg.size() <= i)
                break;
            if (arg.get(i) instanceof PhysicalRegister && ((PhysicalRegister) arg.get(i)).isFuncArg() && ((PhysicalRegister) arg.get(i)).getArgIdx() < arg.size()) {
                PhysicalRegister physicalRegister = (PhysicalRegister)arg.get(i);
                if(funcArgOffsetMap.containsKey(physicalRegister))
                    funcArgOffset.add(funcArgOffsetMap.get(physicalRegister));
                else{
                    funcArgOffset.add(Offset);
                    funcArgOffsetMap.put(physicalRegister, Offset);
                    inst.prependInst(new PushInst(inst.parentBB, physicalRegister));
                    Offset++;
                }
            }
            else
                funcArgOffset.add(-1);
        }

        for(int i = 0; i < 6; ++ i){
            if(arg.size() <= i)
                break;
            if(funcArgOffset.get(i) == -1){
                if(arg.get(i) instanceof StackSlot){
                    inst.prependInst(new LoadInst(inst.parentBB, rax, rbp, 8, funcInfo.stackSlotOffsetMap.get(arg.get(i))));
                    inst.prependInst(new MoveInst(inst.parentBB, funcArg.get(i), rax));
                }
                else
                    inst.prependInst(new MoveInst(inst.parentBB, funcArg.get(i), arg.get(i)));
            }
            else
                inst.prependInst(new LoadInst(inst.parentBB, funcArg.get(i), rsp, 8, 8 * (Offset - funcArgOffset.get(i) - 1)));
        }

        if(Offset > 0)
            inst.prependInst(new BinaryOpInst(inst.parentBB, rsp, BinaryOpInst.BinaryOps.ADD, rsp, new IntImmValue(Offset * 8)));
        // get return value
        if(inst.dest != null)
            inst.appendInst(new MoveInst(inst.parentBB, inst.dest, rax));
        // restore caller save registers
        for(PhysicalRegister physicalRegister : funcInfo.usedCallerSaveReg){
            if(physicalRegister.isFuncArg() && physicalRegister.getArgIdx() < func.argVRegList.size())
                continue;
            if(calleeFuncInfo.recursiveUsedReg.contains(physicalRegister))
                inst.appendInst(new PopInst(inst.parentBB, physicalRegister));
        }
        // restore argument registers
        for(int i = 0; i < PushFuncArgRegNum; ++ i)
            inst.appendInst(new PopInst(inst.parentBB, funcArg.get(i)));
        // remove extra arguments
        if(calleeFuncInfo.ExtraArgNum > 0 || extraPush){
            int PushArgNum = extraPush ? calleeFuncInfo.ExtraArgNum + 1 : calleeFuncInfo.ExtraArgNum;
            inst.appendInst(new BinaryOpInst(inst.parentBB, rsp, BinaryOpInst.BinaryOps.ADD, rsp, new IntImmValue(PushArgNum * 8)));
        }
    }

    private void processHeapAlloc(HeapAllocInst inst, FuncInfo funcInfo){
        int PushCallerSaveNum = 0;
        for(PhysicalRegister physicalRegister : funcInfo.usedCallerSaveReg){
            PushCallerSaveNum ++;
            inst.prependInst(new PushInst(inst.parentBB, physicalRegister)); }
        // set argument
        inst.prependInst(new MoveInst(inst.parentBB, rdi, ((HeapAllocInst)inst).allocSize));
        if(PushCallerSaveNum  % 2 == 1)//align rsp
            inst.prependInst(new PushInst(inst.parentBB, new IntImmValue(0)));
        // get return value
        inst.appendInst(new MoveInst(inst.parentBB, ((HeapAllocInst)inst).dest, rax));
        // restore caller save registers
        for(PhysicalRegister physicalRegister : funcInfo.usedCallerSaveReg)
            inst.appendInst(new PopInst(inst.parentBB, physicalRegister));
        // restore rsp
        if(PushCallerSaveNum % 2 == 1)
            inst.appendInst(new BinaryOpInst(inst.parentBB, rsp, BinaryOpInst.BinaryOps.ADD, rsp, new IntImmValue(8)));
    }

    private void processLoad(LoadInst inst, FuncInfo funcInfo){
        if(inst.addr instanceof StackSlot){
            inst.addrOffset = funcInfo.stackSlotOffsetMap.get(inst.addr);
            inst.addr = rbp;
        }
    }

    private void processStore(StoreInst inst, FuncInfo funcInfo){
        if(inst.addr instanceof StackSlot){
            inst.addrOffset = funcInfo.stackSlotOffsetMap.get(inst.addr);
            inst.addr = rbp;
        }
    }

    private void processMove(MoveInst inst){
        if(inst.dest == inst.source)
            inst.remove();
    }

    public void process(){
        calcFrame();
        calcRecursiveRegUse();
        processFunc();
    }
}