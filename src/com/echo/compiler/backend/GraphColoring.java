package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;
import com.echo.compiler.NASM.NASMRegisterSet;
import com.echo.compiler.error.CompilerError;

import java.util.*;

import static com.echo.compiler.NASM.NASMRegisterSet.*;

public class GraphColoring {
    private class VRInfo{
        Set<VirtualRegister> neighbour = new HashSet<>();
        int degree = 0;
        boolean removed = false;
        Register color = null;
        Set<VirtualRegister> suggestSameVreg = new HashSet<>();
    }

    public IRRoot ir;
    public List<PhysicalRegister> physicalRegisters;
    public int colornumber;
    public Func currentFunc;
    public PhysicalRegister tmp0, tmp1;
    public Map<VirtualRegister, VRInfo> vrInfoMap = new HashMap<>();
    public Stack<VirtualRegister> stack = new Stack<>();
    public Set<VirtualRegister> nodes = new HashSet<>();
    public Set<VirtualRegister> SmallDegreeNodes = new HashSet<>();
    public Map<Register, Register> renameMap = new HashMap<>();
    public Set<PhysicalRegister> UsedColor = new HashSet<>();

    public GraphColoring(IRRoot ir){
        this.ir = ir;
        this.physicalRegisters = new ArrayList<>(NASMRegisterSet.generalRegs);
        for (Func func : ir.funcs.values()) {
            if (func.argVRegList.size() > ir.maxFuncArgNum)
                ir.maxFuncArgNum = func.argVRegList.size();
        }
        if (ir.maxFuncArgNum >= 5)
            physicalRegisters.remove(r8);
        if (ir.maxFuncArgNum >= 6)
            physicalRegisters.remove(r9);
        if (ir.hasDivShiftInst) {
            tmp0 = physicalRegisters.get(0);
            tmp1 = physicalRegisters.get(1);
        }
        else {
            tmp0 = rbx;
            tmp1 = physicalRegisters.get(0);
        }
        ir.reg0 = tmp0;
        ir.reg1 = tmp1;
        this.physicalRegisters.remove(tmp0);
        this.physicalRegisters.remove(tmp1);
        this.colornumber = physicalRegisters.size();
    }

    private void BuildGraph(){
        for(VirtualRegister argVreg : currentFunc.argVRegList)
            getVRInfo(argVreg);
        for(BasicBlock BB : currentFunc.getReversePreOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                Register defined = inst.getDefinedRegister();
                if(defined instanceof VirtualRegister) {
                    VRInfo vrInfo = getVRInfo((VirtualRegister) defined);
                    if (inst instanceof MoveInst) {
                        Value source = (((MoveInst) inst).source);
                        if (source instanceof VirtualRegister) {//a register to register copy
                            vrInfo.suggestSameVreg.add((VirtualRegister) source);
                            getVRInfo((VirtualRegister) source).suggestSameVreg.add((VirtualRegister) defined);
                        }
                        for (VirtualRegister register : inst.liveout) {
                            if (register != source && register != defined)
                                addEdge(register, (VirtualRegister) defined);
                        }
                    }
                    else {
                        for (VirtualRegister register : inst.liveout) {
                            if (register != defined)
                                addEdge(register, (VirtualRegister) defined);
                        }
                    }
                }
            }
        }
        for(VRInfo vrInfo : vrInfoMap.values())
            vrInfo.degree = vrInfo.neighbour.size();
    }

    private VRInfo getVRInfo(VirtualRegister register){
        VRInfo vrInfo = vrInfoMap.get(register);
        if(vrInfo == null){
            vrInfo = new VRInfo();
            vrInfoMap.put(register, vrInfo);
        }
        return vrInfo;
    }

    private void addEdge(VirtualRegister register1, VirtualRegister register2){
        getVRInfo(register1).neighbour.add(register2);
        getVRInfo(register2).neighbour.add(register1);
    }

    private void removeNode(VirtualRegister register){
        VRInfo vrInfo = vrInfoMap.get(register);
        for(VirtualRegister neighbour : vrInfo.neighbour){
            VRInfo neighbourInfo = vrInfoMap.get(neighbour);
            if(!neighbourInfo.removed){
                neighbourInfo.degree--;
                if(neighbourInfo.degree < colornumber)
                    SmallDegreeNodes.add(neighbour);
            }
        }
        vrInfo.removed = true;
        nodes.remove(register);
    }

    private void coloring(){
        for(VirtualRegister register: vrInfoMap.keySet())
            nodes.add(register);
        for(VirtualRegister register : nodes){
            if(vrInfoMap.get(register).degree < colornumber)
                SmallDegreeNodes.add(register);
        }
        stack.clear();
        while(!nodes.isEmpty()){
            //    Until there are nodes with degree < k:
            //        choose such node and push it into the stack;
            //        delete the node and all its edges from the graph.
            while (!SmallDegreeNodes.isEmpty()) {
                Iterator<VirtualRegister> iterator = SmallDegreeNodes.iterator();
                VirtualRegister register = iterator.next();
                stack.push(register);
                iterator.remove();
                removeNode(register);
            }
            //      If the graph is non-empty (and all nodes have degree > k), then:
            //          choose a node, push it into the stack, and delete it (together with edges) from the graph;
            //          if this results to some nodes with degree < k, then go to the step 1;
            //          otherwise continue with the step 2.
            if(!nodes.isEmpty()) {
                Iterator<VirtualRegister> iterator = nodes.iterator();
                VirtualRegister register = iterator.next();
                stack.push(register);
                iterator.remove();
                removeNode(register);
            }
        }
        //      Pop a node from the stack and color it by the least free color.
        //          If there is no free colors, then choose an uncolored node, spill it into the memory, and go to the step 1.
        while (!stack.empty()) {
            VirtualRegister register = stack.pop();
            VRInfo vrInfo = vrInfoMap.get(register);
            UsedColor = new HashSet<>();
            for(VirtualRegister neighbour : vrInfo.neighbour){
                VRInfo neighbourInfo = vrInfoMap.get(neighbour);
                if(!neighbourInfo.removed && neighbourInfo.color instanceof PhysicalRegister)
                    UsedColor.add((PhysicalRegister)neighbourInfo.color);
            }
            PhysicalRegister forced = register.forcedPhysicalRegister;
            if(forced != null){
                if(UsedColor.contains(forced))
                    throw new CompilerError("forced physical register has been used");
                vrInfo.color = forced;
            }
            else{
                for(VirtualRegister reg : vrInfo.suggestSameVreg){
                    Register regcolor = getVRInfo(reg).color;
                    if(regcolor instanceof PhysicalRegister && !UsedColor.contains(regcolor)){
                        vrInfo.color = regcolor;
                        break;
                    }
                }
                if (vrInfo.color == null) {
                    for(PhysicalRegister reg : physicalRegisters){
                        if(!UsedColor.contains(reg)){
                            vrInfo.color = reg;
                            break;
                        }
                    }
                    if(vrInfo.color == null){
                        vrInfo.color = currentFunc.argsStaticSlotMap.get(register);
                        if(vrInfo.color == null)
                            vrInfo.color = new StackSlot(currentFunc, register.name, false);
                    }
                }
            }
            vrInfo.removed = false;
        }
    }
//remain to understand
    private void UpdateInst(){
        for(BasicBlock BB : currentFunc.getReversePreOrder()){
            for(Inst inst = BB.firstInst; inst != null; inst = inst.nextInst){
                List<Register> used = inst.usedRegisters;
                if(inst instanceof FuncCallInst){
                    List<Value> args = ((FuncCallInst) inst).args;
                    for(int i = 0; i < args.size(); ++ i){
                        Value value = args.get(i);
                        if(value instanceof VirtualRegister)
                            args.set(i, vrInfoMap.get(value).color);
                    }
                }
                else{
                    if (!used.isEmpty()) {
                        boolean tmp0Used = false;
                        renameMap = new HashMap<>();
                        for(Register register : used){
                            if(register instanceof VirtualRegister){
                                Register color = vrInfoMap.get(register).color;
                                if(color instanceof StackSlot){
                                    PhysicalRegister reg = tmp0Used ? tmp0 : tmp1;
                                    inst.prependInst(new LoadInst(BB, reg, color, 8, 0));
                                    tmp0Used = true;
                                    renameMap.put(register, reg);
                                    currentFunc.usedPhysicalGeneralRegs.add(reg);
                                }
                                else{
                                    renameMap.put(register, color);
                                    currentFunc.usedPhysicalGeneralRegs.add((PhysicalRegister)color);
                                }
                            }
                            else
                                renameMap.put(register, register);
                        }
                    }
                    inst.setUsedRegisters(renameMap);
                }
                Register defined = inst.getDefinedRegister();
                if (defined instanceof VirtualRegister) {
                    Register color = vrInfoMap.get(defined).color;
                    if (color instanceof StackSlot) {
                        inst.appendInst(new StoreInst(BB, tmp0, color, 8, 0));
                        inst.setDefinedRegister(tmp0);
                        currentFunc.usedPhysicalGeneralRegs.add(tmp0);
                        inst = inst.nextInst;
                    }
                    else{
                        inst.setDefinedRegister(color);
                        currentFunc.usedPhysicalGeneralRegs.add((PhysicalRegister)color);
                    }
                }
            }
        }
    }

    public void process(){
        for(Func func : ir.funcs.values()){
            currentFunc = func;
            vrInfoMap.clear();
            stack.clear();
            nodes.clear();
            SmallDegreeNodes.clear();

            BuildGraph();
            coloring();
            UpdateInst();
        }
    }
}
