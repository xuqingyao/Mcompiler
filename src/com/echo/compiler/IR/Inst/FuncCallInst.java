package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.Register.VirtualRegister;
import com.echo.compiler.IR.IRVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FuncCallInst extends Inst {
    public Func func;
    public List<Value> args;
    public Register dest;

    public FuncCallInst(BasicBlock parentBB, Func func, List<Value> args, Register dest){
        super(parentBB);
        this.func = func;
        this.args = args;
        this.dest = dest;
        reloadUsedRegistersRegValues();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        for(int i = 0; i < args.size(); ++ i){
            if(args.get(i) instanceof Register)
                args.set(i, renameMap.get(args.get(i)));
        }
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public FuncCallInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        List<Value> copyargs = new ArrayList<>();
        for(Value arg : args)
            copyargs.add((Value)renameMap.getOrDefault(arg, arg));
        VirtualRegister Dest = (VirtualRegister)renameMap.getOrDefault(dest, dest);
        FuncCallInst funcCallInst = new FuncCallInst(ParentBB, func, copyargs, Dest);
        return funcCallInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        for(Value arg : args){
            if(arg instanceof Register)
                usedRegisters.add((Register)arg);
            usedRegValues.add(arg);
        }
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
