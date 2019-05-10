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
            inst.liveIn.clear();
            inst.liveout.clear();
        }
    }


    public void processFunc(Func func){
        //  for each node n in CFG                                                      ----initialize solutions
        //      in[n] = empty; out[n] = empty
        List<BasicBlock> reversePreOrder = func.getReversePreOrder();
        for(BasicBlock BB : reversePreOrder)
            init(BB);

        //    repeat
        //      for each node n in CFG
        //          in'[n] = in[n]; out'[n] = out[n]                                    ----save current results
        //          in[n] = use[n] \cup (out[n] – def[n]); out[n] = \cup in[s]          ----solve data-flow equations
        //    until
        //      in'[n] = in[n] and out'[n] = out[n] for all n                          ----test for convergence
        Set<VirtualRegister> in = new HashSet<>();
        Set<VirtualRegister> out = new HashSet<>();
        boolean changed = true;
        while(changed){
            changed = false;
            for(BasicBlock BB : reversePreOrder){
                for(Inst inst = BB.lastInst; inst != null; inst = inst.prevInst){
                    in.clear();
                    out.clear();
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
                    if(!inst.liveIn.equals(in)) {
                        changed = true;
                        inst.liveIn = new HashSet<>(in);
                    }
                    if(!inst.liveout.equals(out)){
                        changed = true;
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
