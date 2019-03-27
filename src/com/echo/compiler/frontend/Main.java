package com.echo.compiler.frontend;

import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.error.ErrorListener;
import com.echo.compiler.parser.mLexer;
import com.echo.compiler.parser.mParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    private static ProgramNode ast;
    private static SymbolTable globalSymbolTable;

    public static void main(String[] args) throws Exception {
        try {
            compile();
        }
        catch (Error e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void compile() throws Exception {
        buildAST();
//        printAST();
        semanticCheck();
    }

    private static void buildAST() throws Exception {
        String inFile = null;
//        String inFile = "C:/Users/echo/Desktop/M_compiler/src/com/echo/compiler/testcase/testcase_197.txt";
        InputStream in;
        if (inFile == null)
            in = System.in;
        else in = new FileInputStream(inFile);
        CharStream input = CharStreams.fromStream(in);
        mLexer lexer = new mLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mParser parser = new mParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.program();
        ASTBuilder astBuilder = new ASTBuilder();
        ast = (ProgramNode) astBuilder.visit(tree);
    }

    private static void printAST() {
        new ASTPrinter().visit(ast);
    }

    private static void semanticCheck() {
        GlobalSymbolTableBuilder globalSymbolTableBuilder= new GlobalSymbolTableBuilder();
        globalSymbolTableBuilder.visit(ast);
        globalSymbolTable = globalSymbolTableBuilder.getSymbolTable();
        new ClassCheck(globalSymbolTable).visit(ast);
        new SemanticChecker(globalSymbolTable).visit(ast);
    }
}
