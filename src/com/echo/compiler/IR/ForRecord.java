package com.echo.compiler.IR;

public class ForRecord {
    public BasicBlock condBB, stepBB, bodyBB, afterBB;
    public boolean processed = false;

    public ForRecord(BasicBlock condBB, BasicBlock stepBB, BasicBlock bodyBB, BasicBlock afterBB){
        this.condBB = condBB;
        this.stepBB = stepBB;
        this.bodyBB = bodyBB;
        this.afterBB = afterBB;
    }
}
