package com.echo.compiler.frontend;

import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.backend.*;
import com.echo.compiler.error.ErrorListener;
import com.echo.compiler.parser.mLexer;
import com.echo.compiler.parser.mParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
    private static ProgramNode ast;
    private static SymbolTable globalSymbolTable;
    private static IRRoot irRoot;

    public static void main(String[] args) throws Exception {
        try {
            compile();
        }
        catch (Error error) {
            System.err.println(error.getMessage());
            System.exit(1);
        }
    }

    private static void compile() throws Exception {
        buildAST();
        semanticCheck();
        buildIR();
//        printIR();
        generateCode();
    }

    private static void buildAST() throws Exception {
//         String inFile = "C:\\Users\\echo\\Downloads\\testcase\\testcase_14.txt";
       String inFile = null;
        InputStream in;
        if (inFile == null)
            in = System.in;
        else
            in = new FileInputStream(inFile);
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
        new ClassVarAdder(globalSymbolTable).visit(ast);
        new SemanticChecker(globalSymbolTable).visit(ast);
    }

    private static void buildIR(){
        IRBuilder irBuilder = new IRBuilder(globalSymbolTable);
        irBuilder.visit(ast);
        irRoot = irBuilder.ir;
    }



    private static void printIR() throws Exception{
        String outFile = null;
        PrintStream outS;
        if (outFile == null)
            outS = System.out;
        else
            outS = new PrintStream(new FileOutputStream(outFile));
        new IRPrinter(outS).visit(irRoot);
    }



    private static void generateCode() throws Exception{
//         String outFile = "C:\\Users\\echo\\Desktop\\Mcompiler\\src\\com\\echo\\compiler\\prog.asm";
       String outFile = null;
        PrintStream outS;
        if (outFile == null)
            outS = System.out;
        else
            outS = new PrintStream(new FileOutputStream(outFile));
//        new FuncInlineprocess(irRoot).process();
        new Registerprocess(irRoot).process();
        new GlobalVariableProcess(irRoot).processs();
//        new FuncArgprocess(irRoot).process();
//        new naiveallocate(irRoot).process();
//        new LiveAnalysis(irRoot).process();
        new GraphColoring(irRoot).process();
        new NASMTransformer(irRoot).process();
        new NASMPrinter(outS).visit(irRoot);
    }
}
