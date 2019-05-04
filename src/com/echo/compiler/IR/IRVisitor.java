package com.echo.compiler.IR;

import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;

public interface IRVisitor {
    void visit(IRRoot node);
    void visit(Func node);
    void visit(BasicBlock node);
    void visit(BranchJumpInst node);
    void visit(JumpJumpInst node);
    void visit(ReturnJumpInst node);
    void visit(UnaryOpInst node);
    void visit(BinaryOpInst node);
    void visit(CompareInst node);
    void visit(MoveInst node);
    void visit(LoadInst node);
    void visit(StoreInst node);
    void visit(FuncCallInst node);
    void visit(HeapAllocInst node);
    void visit(PopInst node);
    void visit(PushInst node);
    void visit(VirtualRegister node);
    void visit(PhysicalRegister node);
    void visit(IntImmValue node);
    void visit(StaticVarData node);
    void visit(StaticStringData node);
}
