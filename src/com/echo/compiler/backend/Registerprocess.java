package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.BinaryOpInst;
import com.echo.compiler.IR.Inst.Inst;
import com.echo.compiler.IR.Inst.LoadInst;
import com.echo.compiler.IR.Inst.MoveInst;
import com.echo.compiler.IR.Register.StackSlot;
import com.echo.compiler.IR.Register.VirtualRegister;
import com.echo.compiler.NASM.NASMRegisterSet;

public class Registerprocess {
    public IRRoot ir;

    public Registerprocess(IRRoot ir){
        this.ir = ir;
    }

    private void processBinaryRegs(){
        for(Func func : ir.funcs.values()) {
            for (BasicBlock BB : func.getReversePostOrder()) {
                for (Inst inst = BB.firstInst, nextInst; inst != null; inst = nextInst) {
                    nextInst = inst.nextInst;
                    if (inst instanceof BinaryOpInst) {
                        if (((BinaryOpInst) inst).dest == ((BinaryOpInst) inst).getLhs())
                            continue;
                        if (((BinaryOpInst) inst).dest == ((BinaryOpInst) inst).getRhs()) {
                            if (((BinaryOpInst) inst).isCommutativeOp()) {
                                ((BinaryOpInst) inst).setRhs(((BinaryOpInst) inst).getLhs());
                                ((BinaryOpInst) inst).setLhs(((BinaryOpInst) inst).dest);
                            }
                            else {
                                VirtualRegister virtualRegister = new VirtualRegister("rhstmp");
                                inst.prependInst(new MoveInst(inst.parentBB, virtualRegister, ((BinaryOpInst) inst).getRhs()));
                                inst.prependInst(new MoveInst(inst.parentBB, ((BinaryOpInst) inst).dest, ((BinaryOpInst) inst).getLhs()));
                                ((BinaryOpInst) inst).setLhs(((BinaryOpInst) inst).dest);
                                ((BinaryOpInst) inst).setRhs(virtualRegister);
                            }
                        }
                        else if (((BinaryOpInst) inst).op != BinaryOpInst.BinaryOps.DIV && ((BinaryOpInst) inst).op != BinaryOpInst.BinaryOps.MOD) {
                            inst.prependInst(new MoveInst(inst.parentBB, ((BinaryOpInst) inst).dest, ((BinaryOpInst) inst).getLhs()));
                            ((BinaryOpInst) inst).setLhs(((BinaryOpInst) inst).dest);
                        }
                    }
                }
            }
        }
    }

    private void processFuncArgs(){
        for(Func func : ir.funcs.values()) {
            Inst inst = func.startBB.firstInst;
            for (int i = 6; i < func.argVRegList.size(); ++i) {
                VirtualRegister argreg = func.argVRegList.get(i);
                StackSlot argslot = new StackSlot(func, "arg_" + i, true);
                func.argsStaticSlotMap.put(argreg, argslot);
                inst.prependInst(new LoadInst(inst.parentBB, argreg, argslot, 8, 0));
            }
            //set forced register
            if (func.argVRegList.size() > 0)
                func.argVRegList.get(0).forcedPhysicalRegister = NASMRegisterSet.rdi;
            if (func.argVRegList.size() > 1)
                func.argVRegList.get(1).forcedPhysicalRegister = NASMRegisterSet.rsi;
            if (func.argVRegList.size() > 2)
                func.argVRegList.get(2).forcedPhysicalRegister = NASMRegisterSet.rdx;
            if (func.argVRegList.size() > 3)
                func.argVRegList.get(3).forcedPhysicalRegister = NASMRegisterSet.rcx;
            if (func.argVRegList.size() > 4)
                func.argVRegList.get(4).forcedPhysicalRegister = NASMRegisterSet.r8;
            if (func.argVRegList.size() > 5)
                func.argVRegList.get(5).forcedPhysicalRegister = NASMRegisterSet.r9;
        }
    }

    public void process(){
        processBinaryRegs();
        processFuncArgs();
    }
}
