package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;

import java.util.HashMap;
import java.util.Map;

public class uselessDeleteProcess {
    public IRRoot ir;
    private boolean delete = true;
    public Map<BasicBlock, BasicBlock> jumpTargetBB = new HashMap<>();

    public uselessDeleteProcess(IRRoot ir){
        this.ir = ir;
    }

    private boolean ToAnalyze(Inst inst){
        return inst instanceof LoadInst || inst instanceof MoveInst || inst instanceof BinaryOpInst || inst instanceof UnaryOpInst || inst instanceof CompareInst || inst instanceof HeapAllocInst;
    }

    private void AnalyzeDelete(Func func){
        for(BasicBlock BB : func.getReversePreOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.prevInst){
                if(ToAnalyze(inst)){
                    if(inst.getDefinedRegister() == null || !inst.liveout.contains(inst.getDefinedRegister())){
                        delete = true;
                        inst.remove();
                    }
                }
            }
        }
    }

    private void deleteEmptyBB(Func func){
        jumpTargetBB.clear();
        for(BasicBlock BB : func.getReversePostOrder()){
            if(BB.firstInst == BB.lastInst){
                if(BB.firstInst instanceof JumpJumpInst)
                    jumpTargetBB.put(BB, ((JumpJumpInst)(BB.firstInst)).targetBB);
            }
        }
        for(BasicBlock BB : func.getReversePostOrder()){
            Inst lastInst = BB.lastInst;
            if(lastInst instanceof JumpJumpInst)
                ((JumpJumpInst)lastInst).targetBB = resetJumpTarget(((JumpJumpInst)lastInst).targetBB);
            else if(lastInst instanceof BranchJumpInst){
                ((BranchJumpInst) lastInst).thenBB = resetJumpTarget(((BranchJumpInst) lastInst).thenBB);
                ((BranchJumpInst) lastInst).elseBB = resetJumpTarget(((BranchJumpInst) lastInst).elseBB);
                if(((BranchJumpInst) lastInst).thenBB == ((BranchJumpInst) lastInst).elseBB)
                    lastInst.replace(new JumpJumpInst(BB, ((BranchJumpInst) lastInst).thenBB));
            }
        }
    }

    private BasicBlock resetJumpTarget(BasicBlock BB){
        BasicBlock reset = BB, test = jumpTargetBB.get(BB);
        while(test != null){
            reset = test;
            test = jumpTargetBB.get(test);
        }
        return reset;
    }

    public void process(){
        while(delete){
            delete = false;
            for(Func func : ir.funcs.values()){
                if(!func.isBuildIn){
                    AnalyzeDelete(func);
                    deleteEmptyBB(func);
                }
            }
            new LiveAnalysis(ir);
        }
    }
}
