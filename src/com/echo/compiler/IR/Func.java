package com.echo.compiler.IR;

import com.echo.compiler.IR.Inst.FuncCallInst;
import com.echo.compiler.IR.Inst.Inst;
import com.echo.compiler.IR.Inst.ReturnJumpInst;
import com.echo.compiler.IR.Register.PhysicalRegister;
import com.echo.compiler.IR.Register.StackSlot;
import com.echo.compiler.IR.Register.VirtualRegister;
import com.echo.compiler.Symbol.FuncSymbol;

import java.util.*;

public class Func {
    public FuncSymbol funcSymbol;
    public String name;
    public BasicBlock startBB = null, endBB = null;
    public List<VirtualRegister> argVRegList = new ArrayList<>();

    //control flow graph
//    private List<BasicBlock> reversePostOrder = new ArrayList<>(), reversePreOrder = new ArrayList<>();
    private List<BasicBlock> reversePostOrder = null, reversePreOrder = null;
    public List<ReturnJumpInst> returnList = new ArrayList<>();
    public Set<BasicBlock> dfsVisited = new HashSet<>();
    public Set<Func> calleeSet = new HashSet<>();
    public Set<Func> recursiveCalleeSet = new HashSet<>();

    //register allocation
    public Map<VirtualRegister, StackSlot> argsStaticSlotMap = new HashMap<>();
    public List<StackSlot> stackSlots = new ArrayList<>();
    public Set<PhysicalRegister> usedPhysicalGeneralRegs = new HashSet<>();

    //buildIn function
    public String buildInCallLabel;

    public boolean recursiveCall = false;
    public boolean isBuildIn = false;
    public boolean isMemFunc = false;

    public Func(){}

    public Func(FuncSymbol funcSymbol){
        this.funcSymbol = funcSymbol;
        this.name = funcSymbol.getName();
        if(funcSymbol.isMember())
            this.name = "_member_" + funcSymbol.getClassname() + "_" + name;
    }

    public Func(String name, String buildInCallLabel){
        this.name = name;
        this.buildInCallLabel = buildInCallLabel;
        this.funcSymbol = null;
        this.isBuildIn = true;
    }


    public List<BasicBlock> getReversePostOrder() {
        if (reversePostOrder == null)
            calcReversePostOrder();
        return reversePostOrder;
    }

    public List<BasicBlock> getReversePreOrder() {
        if (reversePreOrder == null)
            calcReversePreOrder();
        return reversePreOrder;
    }

    public void updateCalleeSet(){
        calleeSet.clear();
        for(BasicBlock BB : getReversePostOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                if(inst instanceof FuncCallInst)
                    calleeSet.add(((FuncCallInst)inst).func);
            }
        }
    }

    public void addArgVReg(VirtualRegister reg){
        argVRegList.add(reg);
    }

    public BasicBlock genFirstBB(){
        startBB = new BasicBlock(this, funcSymbol.getName() + "_start");
        return startBB;
    }

    private void dfsPostOrder(BasicBlock BB){
        if(dfsVisited.contains(BB))
            return;
        dfsVisited.add(BB);
        for(BasicBlock nextBB : BB.nextBBSet)
            dfsPostOrder(nextBB);
        reversePostOrder.add(BB);
    }

    private void dfsPreOrder(BasicBlock BB){
        if(dfsVisited.contains(BB))
            return;
        dfsVisited.add(BB);
        reversePreOrder.add(BB);
        for(BasicBlock nextBB : BB.nextBBSet)
            dfsPreOrder(nextBB);
    }

    public void calcReversePostOrder(){
        reversePostOrder = new ArrayList<>();
//        dfsVisited = new HashSet<>();
        dfsVisited.clear();
        dfsPostOrder(startBB);
        dfsVisited = null;
        for(int i = 0; i < reversePostOrder.size(); ++ i)
            reversePostOrder.get(i).postOrderIdx = i;
        Collections.reverse(reversePostOrder);
    }

    public void calcReversePreOrder(){
        reversePreOrder = new ArrayList<>();
//        dfsVisited = new HashSet<>();
        dfsVisited.clear();
        dfsPreOrder(startBB);
        dfsVisited = null;
        for(int i = 0; i < reversePreOrder.size(); ++ i)
            reversePreOrder.get(i).preOrderIdx = i;
        Collections.reverse(reversePreOrder);
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
