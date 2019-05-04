package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.BranchJumpInst;
import com.echo.compiler.IR.Inst.Inst;
import com.echo.compiler.IR.Inst.JumpInst;
import com.echo.compiler.IR.Inst.JumpJumpInst;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.Register.VirtualRegister;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LiveAnalysis {
    public IRRoot ir;

    public LiveAnalysis(IRRoot irRoot){
        this.ir = irRoot;
    }

    public void init(BasicBlock BB){
        for (Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
            inst.liveIn = new HashSet<>();
            inst.liveout = new HashSet<>();
        }
    }

    public void processFunc(Func func){
        //initialize
        List<BasicBlock> reversePreOrder = func.getReversePreOrder();
        reversePreOrder.forEach(this::init);

        boolean changed = true;
        while(changed){
            changed = false;
            for(BasicBlock BB : reversePreOrder){
                for(Inst inst = BB.lastInst; inst != null; inst = inst.prevInst){
                    Set<VirtualRegister> in = new HashSet<>();
                    Set<VirtualRegister> out = new HashSet<>();
                    if(inst instanceof JumpInst){
                        if(inst instanceof JumpJumpInst)
                            out.addAll(((JumpJumpInst) inst).targetBB.firstInst.liveIn);
                        else if(inst instanceof BranchJumpInst) {
                            out.addAll(((BranchJumpInst) inst).thenBB.firstInst.liveIn);
                            out.addAll(((BranchJumpInst) inst).elseBB.firstInst.liveIn);
                        }
                    }
                    else if(inst.nextInst != null)
                        out.addAll(inst.nextInst.liveIn);
                    in.addAll(out);
                    Register defined = inst.getDefinedRegister();
                    if(defined instanceof VirtualRegister)
                        in.remove(defined);
                    for(Register usedRegisters : inst.usedRegisters){
                        if(usedRegisters instanceof VirtualRegister)
                            in.add((VirtualRegister)usedRegisters);
                    }
                    if(!inst.liveIn.equals(in) || !inst.liveout.equals(out)){
                        changed = true;
                        inst.liveIn = new HashSet<>(in);
                        inst.liveout = new HashSet<>(out);
                    }
                }
            }
        }
    }

    public void process(){
        for(Func func : ir.funcs.values())
            processFunc(func);
    }
}
