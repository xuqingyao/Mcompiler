package com.echo.compiler.NASM;

import com.echo.compiler.IR.Register.PhysicalRegister;

public class NASMRegister extends PhysicalRegister {
    public String name;
    public boolean isGeneral, isCallerSave, isCalleeSave;
    public int argIdx;

    public NASMRegister(String name, boolean isGeneral, boolean isCallerSave, boolean isCalleeSave, int argIdx){
        this.name = name;
        this.isGeneral = isGeneral;
        this.isCallerSave = isCallerSave;
        this.isCalleeSave = isCalleeSave;
        this.argIdx = argIdx;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isGeneral() {
        return isGeneral;
    }

    @Override
    public boolean isCallerSave() {
        return isCallerSave;
    }

    @Override
    public boolean isCalleeSave() {
        return isCalleeSave;
    }

    @Override
    public int getArgIdx() {
        return argIdx;
    }

    @Override
    public boolean isFuncArg(){
        return argIdx != -1;
    }
}
