package com.echo.compiler.IR;

import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.error.CompilerError;

import java.util.HashSet;
import java.util.Set;

public class BasicBlock {
    public Inst firstInst = null, lastInst = null;
    public Func func;
    public String name;
    public boolean hasJumpInit = false;
    public int postOrderIdx, preOrderIdx;
    public Set<BasicBlock> prevBBSet = new HashSet<>(), nextBBSet = new HashSet<>();

    public BasicBlock(Func func, String name){
        this.func = func;
        this.name = name;
    }

    public void Init(){
        firstInst = null;
        lastInst = null;
        hasJumpInit = false;
    }

    public void addInst(Inst inst){
        if(hasJumpInit)
            throw new CompilerError("can not add an instruction into a finished block");
        if(firstInst == null)
            firstInst = lastInst = inst;
        else{
            lastInst.linkNextInst(inst);
            lastInst = inst;
        }
    }

    public void addPrevBB(BasicBlock BB){
        prevBBSet.add(BB);
    }

    public void addNextBB(BasicBlock BB){
        nextBBSet.add(BB);
        if(BB != null)
            BB.addPrevBB(this);
    }

    public void delePrevBB(BasicBlock BB){
        prevBBSet.remove(BB);
    }

    public void deleNextBB(BasicBlock BB){
        nextBBSet.remove(BB);
        if(BB !=  null)
            BB.delePrevBB(this);
    }

    public void setJumpInst(JumpInst jumpInst){
        addInst(jumpInst);
        hasJumpInit = true;
        if(jumpInst instanceof BranchJumpInst){
            addNextBB(((BranchJumpInst)jumpInst).thenBB);
            addNextBB(((BranchJumpInst)jumpInst).elseBB);
        }
        else if(jumpInst instanceof JumpJumpInst)
            addNextBB(((JumpJumpInst)jumpInst).targetBB);
        else if(jumpInst instanceof ReturnJumpInst)
            func.returnList.add((ReturnJumpInst)jumpInst);
        else
            throw new CompilerError("invalid type of IRJumpInst");
    }

    public void removeJumpInst(){
        hasJumpInit = false;
        if(lastInst instanceof BranchJumpInst){
            deleNextBB(((BranchJumpInst)lastInst).thenBB);
            deleNextBB(((BranchJumpInst)lastInst).elseBB);
        }
        else if(lastInst instanceof JumpJumpInst)
            deleNextBB(((JumpJumpInst)lastInst).targetBB);
        else if(lastInst instanceof ReturnJumpInst)
            func.returnList.remove(lastInst);
        else
            throw new CompilerError("invalid type of IRJumpInst");
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
