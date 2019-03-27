package com.echo.compiler.error;

import com.echo.compiler.ast.Location;

public class SyntaxError extends Error{
    public SyntaxError(Location location, String message) {
        super(String.format("[Syntax Error] at %s: %s", location.toString(), message));
    }
}
