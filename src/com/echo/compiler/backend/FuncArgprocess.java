package com.echo.compiler.backend;

import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.Inst;
import com.echo.compiler.IR.Inst.LoadInst;
import com.echo.compiler.IR.Register.StackSlot;
import com.echo.compiler.IR.Register.VirtualRegister;
import com.echo.compiler.NASM.NASMRegisterSet;

public class FuncArgprocess {
    public IRRoot ir;

    public FuncArgprocess(IRRoot ir){
        this.ir = ir;
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
        processFuncArgs();
    }
}
