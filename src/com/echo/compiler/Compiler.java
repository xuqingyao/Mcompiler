package com.echo.compiler;

import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.backend.*;
import com.echo.compiler.error.ErrorListener;
import com.echo.compiler.frontend.*;
import com.echo.compiler.parser.mLexer;
import com.echo.compiler.parser.mParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;
import java.io.PrintStream;

public class Compiler {
    private InputStream in;
    private PrintStream astOut, irOut, nasmOut;
    private ProgramNode ast;

    public Compiler(InputStream in, PrintStream astOut, PrintStream irOut, PrintStream nasmOut){
        this.in = in;
        this.astOut = astOut;
        this.irOut = irOut;
        this.nasmOut = nasmOut;
    }

    private void ASTBuild() throws Exception{
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

    private void compile() throws Exception{
        ASTBuild();
        GlobalSymbolTableBuilder globalSymbolTableBuilder = new GlobalSymbolTableBuilder();
        globalSymbolTableBuilder.visit(ast);
        SymbolTable globalSymbolTable = globalSymbolTableBuilder.getSymbolTable();
        new ClassVarAdder(globalSymbolTable).visit(ast);
        new SemanticChecker(globalSymbolTable).visit(ast);
        IRBuilder irBuilder = new IRBuilder(globalSymbolTable);
        irBuilder.visit(ast);
        IRRoot ir = irBuilder.ir;
        new FuncInlineprocess(ir).process();
        new GlobalVariableProcess(ir).processs();
        new Registerprocess(ir).process();
        new LiveAnalysis(ir).process();
        new GraphColoring(ir).process();
        new NASMTransformer(ir).process();
        new NASMPrinter(nasmOut).visit(ir);
    }
}
