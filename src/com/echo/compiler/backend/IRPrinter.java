package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.IRVisitor;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;

import java.io.PrintStream;
import java.util.*;

public class IRPrinter implements IRVisitor {
        private PrintStream out;

        public IRPrinter(PrintStream out) {
            this.out = out;
        }

        private Map<BasicBlock, String> bbMap = new HashMap<>();
        private Map<VirtualRegister, String> vregMap = new HashMap<>();
        private Map<StaticData, String> staticDataMap = new HashMap<>();

        private Map<String, Integer> bbCnt = new HashMap<>();
        private Map<String, Integer> vregCnt = new HashMap<>();
        private Map<String, Integer> staticDataCnt = new HashMap<>();

        private Set<BasicBlock> bbVisited = new HashSet<>();

        private boolean isStaticDef;

        private String genID(String name, Map<String, Integer> cnt) {
            int cntName = cnt.getOrDefault(name, 0) + 1;
            cnt.put(name, cntName);
            if (cntName == 1)
                return name;
            return name + "_" + cntName;
        }

        private String getBBID(BasicBlock bb) {
            String id = bbMap.get(bb);
            if (id == null) {
                if (bb.name == null)
                    id = genID("bb", bbCnt);
                else
                    id = genID(bb.name, bbCnt);
                bbMap.put(bb, id);
            }
            return id;
        }

        private String getVRegID(VirtualRegister vreg) {
            String id = vregMap.get(vreg);
            if (id == null) {
                if (vreg.name == null)
                    id = genID("vreg", vregCnt);
                else
                    id = genID(vreg.name, vregCnt);
                vregMap.put(vreg, id);
            }
            return id;
        }

        private String getStaticDataID(StaticData data) {
            String id = staticDataMap.get(data);
            if (id == null) {
                if (data.name == null)
                    id = genID("staticData", staticDataCnt);
                else
                    id = genID(data.name, staticDataCnt);
                staticDataMap.put(data, id);
            }
            return id;
        }

        @Override
        public void visit(IRRoot node) {
            // Static Data
            isStaticDef = true;
            for (StaticData staticData : node.staticDataList)
                staticData.accept(this);
            isStaticDef = false;
            for (StaticStringData staticStr : node.staticStrs.values())
                staticStr.accept(this);
            out.println();
            for (Func func : node.funcs.values())
                func.accept(this);
        }

        @Override
        public void visit(Func node) {
            vregMap = new IdentityHashMap<>();
            vregCnt = new HashMap<>();
            out.printf("func %s ", node.name);
            for (VirtualRegister paraVReg : node.argVRegList)
                out.printf("$%s ", getVRegID(paraVReg));
            out.printf("{\n");
            for (BasicBlock bb : node.getReversePostOrder())
                bb.accept(this);
            out.printf("}\n\n");
        }

        @Override
        public void visit(BasicBlock node) {
            if (bbVisited.contains(node))
                return;
            bbVisited.add(node);
            out.println("%" + getBBID(node) + ":");
            for (Inst inst = node.firstInst; inst != null; inst = inst.nextInst)
                inst.accept(this);
        }

        @Override
        public void visit(BranchJumpInst node) {
            out.print("    br ");
            node.cond.accept(this);
            out.println(" %" + getBBID(node.thenBB) + " %" + getBBID(node.elseBB));
            out.println();
        }

        @Override
        public void visit(JumpJumpInst node) {
            out.printf("    jump %%%s\n\n", getBBID(node.targetBB));
        }

        @Override
        public void visit(ReturnJumpInst node) {
            out.print("    ret ");
            if (node.returnvalue != null)
                node.returnvalue.accept(this);
            else
                out.print("0");
            out.println();
            out.println();
        }

        @Override
        public void visit(UnaryOpInst node) {
            out.print("    ");
            String op = null;
            switch (node.op) {
                case MIUNS:
                    op = "neg";
                    break;
                case TILDE:
                    op = "not";
                    break;
            }
            node.dest.accept(this);
            out.printf(" = %s ", op);
            node.rhs.accept(this);
            out.println();
        }

        @Override
        public void visit(BinaryOpInst node) {
            out.print("    ");
            String op = null;
            switch (node.op) {
                case ADD:
                    op = "add";
                    break;
                case SUB:
                    op = "sub";
                    break;
                case MUL:
                    op = "mul";
                    break;
                case DIV:
                    op = "div";
                    break;
                case MOD:
                    op = "rem";
                    break;
                case LEFT_SHIFT:
                    op = "shl";
                    break;
                case RIGHT_SHIFT:
                    op = "shr";
                    break;
                case AND:
                    op = "and";
                    break;
                case OR:
                    op = "or";
                    break;
                case CARET:
                    op = "xor";
                    break;
            }
            node.dest.accept(this);
            out.printf(" = %s ", op);
            node.getLhs().accept(this);
            out.printf(" ");
            node.getRhs().accept(this);
            out.println();
        }

        @Override
        public void visit(CompareInst node) {
            out.print("    ");
            String op = null;
            switch (node.op) {
                case EQUAL:
                    op = "seq";
                    break;
                case NOT_EQUAL:
                    op = "sne";
                    break;
                case GREATER:
                    op = "sgt";
                    break;
                case GREATER_EQUAL:
                    op = "sge";
                    break;
                case LESS:
                    op = "slt";
                    break;
                case LESS_EQUAL:
                    op = "sle";
                    break;
            }
            node.dest.accept(this);
            out.printf(" = %s ", op);
            node.getLhs().accept(this);
            out.printf(" ");
            node.getRhs().accept(this);
            out.println();
        }

        @Override
        public void visit(MoveInst node) {
            out.print("    ");
            node.dest.accept(this);
            out.print(" = move ");
            node.source.accept(this);
            out.println();
        }

        @Override
        public void visit(LoadInst node) {
            out.print("    ");
            node.dest.accept(this);
            out.printf(" = load %d ", node.size);
            node.addr.accept(this);
            out.println(" " + node.addrOffset);
        }

        @Override
        public void visit(StoreInst node) {
            out.printf("    store %d ", node.size);
            node.addr.accept(this);
            out.print(" ");
            node.value.accept(this);
            out.println(" " + node.addrOffset);
        }

        @Override
        public void visit(FuncCallInst node) {
            out.print("    ");
            if (node.dest != null) {
                node.dest.accept(this);
                out.print(" = ");
            }
            out.printf("call %s ", node.func.name);
            for (Value arg : node.args) {
                arg.accept(this);
                out.print(" ");
            }
            out.println();
        }

        @Override
        public void visit(HeapAllocInst node) {
            out.print("    ");
            node.dest.accept(this);
            out.print(" = alloc ");
            node.allocSize.accept(this);
            out.println();
        }

        @Override
        public void visit(VirtualRegister node) {
            out.print("$" + getVRegID(node));
        }

        @Override
        public void visit(IntImmValue node) {
            out.print(node.value);
        }

        @Override
        public void visit(StaticVarData node) {
            if (isStaticDef)
                out.printf("space @%s %d\n", getStaticDataID(node), node.size);
            else
                out.print("@" + getStaticDataID(node));
        }

        @Override
        public void visit(StaticStringData node) {
            if (isStaticDef)
                out.printf("asciiz @%s %s\n", getStaticDataID(node), node.value);
            else
                out.print("@" + getStaticDataID(node));
        }

        @Override
        public void visit(PhysicalRegister node) {
        }

        @Override
        public void visit(PushInst node) {
        }

        @Override
        public void visit(PopInst node) {
        }
}
