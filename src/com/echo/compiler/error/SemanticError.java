package com.echo.compiler.error;

import com.echo.compiler.ast.Location;

public class SemanticError extends Error{
    public SemanticError(Location location, String message) {
        super(String.format("[Semantic Error] at %s: %s", location.toString(), message));
    }

    public SemanticError(String message) {
        super(String.format("[Semantic Error]: %s", message));
    }
}
