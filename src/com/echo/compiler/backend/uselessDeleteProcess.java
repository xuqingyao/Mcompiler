package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.ForRecord;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        for(ForRecord forRecord : ir.forRecordMap.values()){
            if(forRecord.processed)
                continue;
            boolean isOutside = false;
            if(forRecord.condBB == null || forRecord.stepBB == null || forRecord.bodyBB == null || forRecord.afterBB == null)
                continue;
            List<BasicBlock> BBlist = new ArrayList<>();
            BBlist.add(forRecord.condBB);
            BBlist.add(forRecord.stepBB);
            BBlist.add(forRecord.bodyBB);
            BBlist.add(forRecord.afterBB);
            Inst afterBBfirstInst = forRecord.afterBB.firstInst;
            for(int i = 0; i < 3; ++ i){
                for(Inst inst = BBlist.get(i).firstInst; inst != null; inst = inst.nextInst){
                    if(inst instanceof FuncCallInst || inst instanceof StoreInst || inst instanceof ReturnJumpInst || inst instanceof PushInst || inst instanceof PopInst)
                        isOutside = true;
                    else if(inst.getDefinedRegister() != null){
                        if(afterBBfirstInst.liveIn.contains(inst.getDefinedRegister()))
                            isOutside = true;
                    }
                    else if(inst instanceof JumpJumpInst){
                        if(!BBlist.contains(((JumpJumpInst) inst).targetBB))
                            isOutside = true;
                    }
                    else if(inst instanceof BranchJumpInst){
                        if(!BBlist.contains(((BranchJumpInst) inst).thenBB) || !BBlist.contains(((BranchJumpInst) inst).elseBB))
                            isOutside = true;
                    }
                }
            }
            if(!isOutside){
                forRecord.condBB.init();
                forRecord.condBB.setJumpInst(new JumpJumpInst(forRecord.condBB, forRecord.afterBB));
                forRecord.processed = true;
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
