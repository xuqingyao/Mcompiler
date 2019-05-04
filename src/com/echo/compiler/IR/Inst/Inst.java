package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.Register.VirtualRegister;
import com.echo.compiler.IR.IRVisitor;
import com.echo.compiler.error.CompilerError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Inst {
    public Inst prevInst = null, nextInst = null;
    public BasicBlock parentBB;
    public List<Register> usedRegisters = new ArrayList<>();
    public List<Value> usedRegValues = new ArrayList<>();
    public boolean removed = false;
    public Set<VirtualRegister> liveIn = null, liveout = null;

    public Inst(BasicBlock parentBB){
        this.parentBB = parentBB;
    }

    public void prependInst(Inst inst){
        if(prevInst != null)
            prevInst.linkNextInst(inst);
        else
            parentBB.firstInst = inst;
        inst.linkNextInst(this);
    }

    public void appendInst(Inst inst){
        if(nextInst != null)
            nextInst.linkPrevInst(inst);
        else
            parentBB.lastInst = inst;
        inst.linkPrevInst(this);
    }

    public void linkPrevInst(Inst inst){
        this.prevInst = inst;
        inst.nextInst = this;
    }

    public void linkNextInst(Inst inst){
        this.nextInst = inst;
        inst.prevInst = this;
    }

    public void remove(){
        if(removed)
            throw new CompilerError("can not remove an instruction which is already removed");
        removed = true;
        if(this instanceof JumpInst)
            parentBB.removeJumpInst();
        if(prevInst != null)
            prevInst.nextInst = nextInst;
        if(nextInst != null)
            nextInst.prevInst = prevInst;
        if(this == parentBB.firstInst)
            parentBB.firstInst = nextInst;
        if(this == parentBB.lastInst)
            parentBB.lastInst = prevInst;
    }

    public void replace(Inst inst){
        if(removed)
            throw new CompilerError("can not replace an instruction which is already removed");
        removed = true;
        inst.prevInst = prevInst;
        inst.nextInst = nextInst;
        if(prevInst != null)
            prevInst.nextInst = inst;
        if(nextInst != null)
            nextInst.prevInst = inst;
        if(this == parentBB.firstInst)
            parentBB.firstInst = inst;
        if(this == parentBB.lastInst)
            parentBB.lastInst = inst;
    }

    public abstract Register getDefinedRegister();

    public abstract void setUsedRegisters(Map<Register, Register> renameMap);

    public abstract void setDefinedRegister(Register reg);

    public abstract Inst copyRename(Map<Object, Object> renameMap);

    public abstract void reloadUsedRegistersRegValues();

    public abstract void accept(IRVisitor visitor);
}
