package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;
import jdk.nashorn.internal.ir.FunctionCall;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class naiveallocate {
    public IRRoot ir;
    private Map<Register, Register> renameMap = new HashMap<>();
    private List<PhysicalRegister> physicalRegisters;
    private Map<VirtualRegister, StackSlot> StackSlotMap = new HashMap<>();

    public naiveallocate(IRRoot ir){
        this.ir = ir;
    }

    private StackSlot getStackSlot(VirtualRegister reg, Func func) {
        StackSlot stackSlot = StackSlotMap.get(reg);
        if (stackSlot == null) {
            stackSlot = new StackSlot(func, reg.name, false);
            StackSlotMap.put(reg, stackSlot);
        }
        return stackSlot;
    }

    private void naiveAllocate() {
        for (Func func : ir.funcs.values()) {
            StackSlotMap.clear();
            StackSlotMap.putAll(func.argsStaticSlotMap);
            for (BasicBlock bb : func.getReversePostOrder()) {
                for (Inst inst = bb.firstInst; inst != null; inst = inst.nextInst) {
                    int cnt = 0;
                    if (inst instanceof FunctionCall) {
                        List<Value> argsList = ((FuncCallInst)inst).args;
                        for (int i = 0; i < argsList.size(); ++i) {
                            Value regValue = argsList.get(i);
                            if (regValue instanceof VirtualRegister) {
                                PhysicalRegister physicalRegister = ((VirtualRegister) regValue).forcedPhysicalRegister;
                                if (physicalRegister != null)
                                    argsList.set(i, physicalRegister);
                                else
                                    argsList.set(i, getStackSlot((VirtualRegister) regValue, func));
                            }
                        }
                    }
                    else {
                        Collection<Register> usedRegisters = inst.usedRegisters;
                        if (!usedRegisters.isEmpty()) {
                            renameMap.clear();
                            for (Register register : usedRegisters) {
                                if (register instanceof VirtualRegister) {
                                    PhysicalRegister physicalRegister = ((VirtualRegister) register).forcedPhysicalRegister;
                                    boolean isFuncArg = false;
                                    if (physicalRegister == null)
                                        physicalRegister = physicalRegisters.get(cnt++);
                                    else
                                        isFuncArg = true;
                                    renameMap.put(register, physicalRegister);
                                    func.usedPhysicalGeneralRegs.add(physicalRegister);
                                    if (isFuncArg)
                                        continue;
                                    inst.prependInst(new LoadInst(bb, physicalRegister, getStackSlot((VirtualRegister) register, func), 8, 0));
                                }
                                else
                                    renameMap.put(register, register);
                            }
                            inst.setUsedRegisters(renameMap);
                        }
                    }
                    Register definedRegister = inst.getDefinedRegister();
                    if (inst instanceof BinaryOpInst && !(((BinaryOpInst) inst).op == BinaryOpInst.BinaryOps.DIV || ((BinaryOpInst) inst).op == BinaryOpInst.BinaryOps.MOD)) {
                        if (definedRegister instanceof  VirtualRegister)
                            inst.appendInst(new StoreInst(bb, ((BinaryOpInst) inst).getLhs(), getStackSlot((VirtualRegister) definedRegister, func), 8, 0));
                        inst.setDefinedRegister((Register) ((BinaryOpInst) inst).getLhs());
                        continue;
                    }
                    if (definedRegister instanceof VirtualRegister) {
                        PhysicalRegister physicalRegister = ((VirtualRegister) definedRegister).forcedPhysicalRegister;
                        if (physicalRegister == null)
                            physicalRegister = physicalRegisters.get(cnt++);
                        func.usedPhysicalGeneralRegs.add(physicalRegister);
                        inst.setDefinedRegister(physicalRegister);
                        inst.appendInst(new StoreInst(bb, physicalRegister,  getStackSlot((VirtualRegister) definedRegister, func), 8,0));
                    }
                }
            }
        }
    }

    public void process(){
        naiveAllocate();
    }
}
