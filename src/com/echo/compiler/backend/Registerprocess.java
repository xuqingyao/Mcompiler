package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.BinaryOpInst;
import com.echo.compiler.IR.Inst.Inst;
import com.echo.compiler.IR.Inst.MoveInst;
import com.echo.compiler.IR.Register.VirtualRegister;

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
                    if (!(inst instanceof BinaryOpInst))
                        continue;
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

    public void process(){
        processBinaryRegs();
    }
}
