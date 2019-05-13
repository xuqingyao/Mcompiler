package com.echo.compiler.IR;

import com.echo.compiler.IR.Register.PhysicalRegister;
import com.echo.compiler.IR.Register.StaticData;
import com.echo.compiler.IR.Register.StaticStringData;
import com.echo.compiler.NASM.NASMRegisterSet;
import com.echo.compiler.ast.StatNode.StatNode;

import java.util.*;

public class IRRoot {
    public Map<String, Func> funcs = new HashMap<>(), buildInFuncs = new HashMap<>();
    public Map<String, StaticStringData> staticStrs = new HashMap<>();
    public List<StaticData> staticDataList = new ArrayList<>();
    public boolean hasDivShiftInst = false;
    public PhysicalRegister reg0, reg1;
    public int maxFuncArgNum;
    public Map<StatNode, ForRecord> forRecordMap = new HashMap<>();

    public IRRoot() {
        insertBuildInFuncs();
    }

    public void insertBuildInFuncs(){
        insertBuildInFunc("_builtin_string_concat", "_builtin_string_concat");
        insertBuildInFunc("_builtin_string_equal", "_builtin_string_equal");
        insertBuildInFunc("_builtin_string_not_equal", "_builtin_string_not_equal");
        insertBuildInFunc("_builtin_string_less", "_builtin_string_less");
        insertBuildInFunc("_builtin_string_less_equal", "_builtin_string_less_equal");
        insertBuildInFunc("print", "_print");
        insertBuildInFunc("println", "_println");
        insertBuildInFunc("printInt", "_printInt");
        insertBuildInFunc("printlnInt", "_printlnInt");
        insertBuildInFunc("getString", "_getString");
        insertBuildInFunc("getInt", "_getInt");
        insertBuildInFunc("toString", "_toString");
        insertBuildInFunc("_member_string_substring", "_member_string_substring");
        insertBuildInFunc("_member_string_parseInt", "_member_string_parseInt");
        insertBuildInFunc("_member_string_ord", "_member_string_ord");
    }

    public void insertBuildInFunc(String name, String label) {
        Func func = new Func(name, label);
        func.usedPhysicalGeneralRegs.addAll(NASMRegisterSet.generalRegs);
        buildInFuncs.put(func.name, func);
    }

    public void addIRStaticData(StaticData staticData){
        staticDataList.add(staticData);
    }

    public void removeFunc(String funcName){
        funcs.remove(funcName);
    }

    public void addFunc(Func func) {
        funcs.put(func.name, func);
    }

    public Func getFunc(String name) {
        return funcs.get(name);
    }

    public Func getBuiltInFunc(String name) {
        return buildInFuncs.get(name);
    }

    public void addStaticStr(StaticStringData staticStr) {
        staticStrs.put(staticStr.value, staticStr);
    }

    public StaticStringData getStaticStr(String str) {
        return staticStrs.get(str);
    }

    public void updateCalleeSet() {
        Set<Func> recursiveCalleeSet = new HashSet<>();
        for (Func function : funcs.values())
            function.recursiveCalleeSet.clear();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Func function : funcs.values()) {
                recursiveCalleeSet.clear();
                recursiveCalleeSet.addAll(function.calleeSet);
                for (Func calleeFunction : function.calleeSet)
                    recursiveCalleeSet.addAll(calleeFunction.recursiveCalleeSet);
                if (!recursiveCalleeSet.equals(function.recursiveCalleeSet)) {
                    function.recursiveCalleeSet.clear();
                    function.recursiveCalleeSet.addAll(recursiveCalleeSet);
                    changed = true;
                }
            }
        }
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
