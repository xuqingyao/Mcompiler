package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;

import java.util.*;

public class GlobalVariableProcess {
    private class FuncInfo{
        Set<StaticData> definedStaticData = new HashSet<>();
        Set<StaticData> recursiveStaticUed = new HashSet<>();
        Set<StaticData> recursiveStaticDefined = new HashSet<>();
        Map<StaticData, VirtualRegister> staticMap = new HashMap<>();
    }

    public IRRoot ir;
    private Map<Func, FuncInfo> funcFuncInfoMap = new HashMap<>();

    public GlobalVariableProcess(IRRoot ir){
        this.ir = ir;
    }

    private VirtualRegister getVirtualRegister(StaticData staticData, Map<StaticData, VirtualRegister> staticMap){
        VirtualRegister register = staticMap.get(staticData);
        if(register == null){
            register = new VirtualRegister(staticData.name);
            staticMap.put(staticData, register);
        }
        return register;
    }

    private boolean isLoadStore(Inst inst){
        return (inst instanceof LoadInst && ((LoadInst)inst).isStatic) || (inst instanceof StoreInst && ((StoreInst)inst).isStatic);
    }

    private void processFunction(Func func){
        FuncInfo funcInfo = new FuncInfo();
        funcFuncInfoMap.put(func, funcInfo);
        Map<StaticData, VirtualRegister> staticMap = funcInfo.staticMap;
        Set<StaticData> definedStaticData = funcInfo.definedStaticData;
        Map<Register, Register> renameMap = new HashMap<>();

        for(BasicBlock BB : func.getReversePostOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                if(!isLoadStore(inst)){
                    List<Register> used = inst.usedRegisters;
                    if (!used.isEmpty()) {
                        renameMap.clear();
                        for(Register register : used){
                            if(register instanceof StaticData && !(register instanceof StaticStringData))
                                renameMap.put(register, getVirtualRegister((StaticData)register, funcInfo.staticMap));
                            else
                                renameMap.put(register, register);
                        }
                        inst.setUsedRegisters(renameMap);
                    }
                    Register defined = inst.getDefinedRegister();
                    if (defined instanceof StaticData) {
                        VirtualRegister register = getVirtualRegister((StaticData)defined, staticMap);
                        inst.setDefinedRegister(register);
                        definedStaticData.add((StaticData)defined);
                    }
                }
            }
        }
        //load the static at the beginning  of the function
        BasicBlock bb = func.startBB;
        Inst firstInst = bb.firstInst;
        for(StaticData staticData : funcInfo.staticMap.keySet())
            firstInst.prependInst(new LoadInst(bb, funcInfo.staticMap.get(staticData), staticData, 8, staticData instanceof StaticStringData));
    }

    public void processs(){
        for(Func func : ir.funcs.values())
            processFunction(func);
        for(Func func : ir.buildInFuncs.values())
            funcFuncInfoMap.put(func, new FuncInfo());
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            funcInfo.recursiveStaticUed.addAll(funcInfo.staticMap.keySet());
            funcInfo.recursiveStaticDefined.addAll(funcInfo.definedStaticData);
            for(Func calleeFunc : func.recursiveCalleeSet){
                FuncInfo calleeFuncInfo = funcFuncInfoMap.get(calleeFunc);
                funcInfo.recursiveStaticUed.addAll(calleeFuncInfo.staticMap.keySet());
                funcInfo.recursiveStaticDefined.addAll(calleeFuncInfo.definedStaticData);
            }
        }
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            Set<StaticData> used = funcInfo.staticMap.keySet();
            if(!used.isEmpty()){
                for(BasicBlock BB : func.getReversePostOrder()){
                    for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                        if (inst instanceof FuncCallInst) {
                            Func calleeFunc = ((FuncCallInst) inst).func;
                            FuncInfo calleeFuncInfo = funcFuncInfoMap.get(calleeFunc);
                            //store defined static data before function call
                            for(StaticData staticData : funcInfo.definedStaticData){
                                if(staticData instanceof StaticStringData)
                                    continue;
                                if(calleeFuncInfo.recursiveStaticUed.contains(staticData))
                                    inst.prependInst(new StoreInst(BB, funcInfo.staticMap.get(staticData), staticData, 8));
                            }
                            //load used static data after function call
                            if(!calleeFuncInfo.recursiveStaticDefined.isEmpty()){
                                Set<StaticData> loadStaticSet = new HashSet<>();
                                loadStaticSet.addAll(calleeFuncInfo.recursiveStaticDefined);
                                loadStaticSet.retainAll(used);
                                for(StaticData staticData : loadStaticSet){
                                    if(!(staticData instanceof StaticStringData))
                                        inst.appendInst(new LoadInst(BB, funcInfo.staticMap.get(staticData), staticData, 8, false));
                                }
                            }
                        }
                    }
                }
            }
        }
        for(Func func : ir.funcs.values()){
            FuncInfo funcInfo = funcFuncInfoMap.get(func);
            ReturnJumpInst returnJumpInst = func.returnList.get(0);
            //store defined static data at the end of the function
            for(StaticData staticData : funcInfo.definedStaticData)
                returnJumpInst.prependInst(new StoreInst(returnJumpInst.parentBB, funcInfo.staticMap.get(staticData), staticData, 8));
        }
    }
}
