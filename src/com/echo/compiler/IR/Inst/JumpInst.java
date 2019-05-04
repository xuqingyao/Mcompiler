package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public abstract class JumpInst extends Inst {
    public JumpInst(BasicBlock parentBB){
        super(parentBB);
    }

    public abstract void accept(IRVisitor visitor);

    @Override
    public abstract JumpInst copyRename(Map<Object, Object> renameMap);
}
