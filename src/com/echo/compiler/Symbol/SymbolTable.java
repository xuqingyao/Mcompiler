package com.echo.compiler.Symbol;

import com.echo.compiler.ast.Location;
import com.echo.compiler.error.SemanticError;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> member = new HashMap<>();
    private SymbolTable parent;
    private boolean isTop = false;
    private boolean isClass;

    public SymbolTable(){}

    public SymbolTable(SymbolTable parent, boolean isClass){
        this.parent = parent;
        this.isClass = isClass;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public Map<String, Symbol> getMember() {
        return member;
    }

    public boolean isClass() {
        return isClass;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public void put(String name, String key, Symbol symbol){
        if(!key.startsWith("$"))
            throw new SemanticError(String.format("Symbol symbol key Should start with \'$\'"));
        if(member.containsKey(key))
            throw new SemanticError(String.format("\"%s\" has been already defined", name));
        member.put(key, symbol);
    }

    public void put(Location location, String name, String key, Symbol symbol) {
        if (!key.startsWith("$"))
            throw new SemanticError(location, String.format("Symbol key Should start with \'$\'"));
        if (member.containsKey(key)) throw new SemanticError(location, String.format("\"%s\" has been already defined", name));
        member.put(key, symbol);
    }

    public Symbol get(String key) {
        Symbol symbol = member.get(key);
        if (symbol != null || isTop)
            return symbol;
        return parent.get(key);
    }

    public Symbol get(Location location, String name, String key) {
        Symbol symbol = member.get(key);
        if (symbol != null)
            return symbol;
        if (isTop)
            throw new SemanticError(location, String.format("Symbol \"%s\" not found", name));
        else return parent.get(location, name, key);
    }

    public Symbol selfGetVarFunc(Location location, String name) {
        if (member.containsKey("$VAR_" + name))
            return member.get("$VAR_" + name);
        if (member.containsKey("$FUNC_" + name))
            return member.get("$FUNC_" + name);
        throw new SemanticError(location, String.format("Symbol \"%s\" not found", name));
    }

    public Symbol getVarFunc(Location location, String name) {
        if (member.containsKey("$VAR_" + name))
            return member.get("$VAR_" + name);
        if (member.containsKey("$FUNC_" + name))
            return member.get("$FUNC_" + name);
        if (isTop)
            throw new SemanticError(location, String.format("Symbol \"%s\" not found", name));
        return parent.getVarFunc(location, name);
    }
}
