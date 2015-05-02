package Calculator.Operators;

import Calculator.Operators.Arithmetic.*;
import Calculator.Operators.Trigonometric.*;
import Calculator.Operators.MemoryBased.*;
import Calculator.Operators.Operator;
import Calculator.Operators.OtherBinary.*;
import Calculator.Operators.OtherUnary.*;

/**
 * Created by Pranav on 01-05-2015.
 */
public class OperatorFactory {

    public static Operator getOperator(String op)
    {

        switch (op.toLowerCase()){
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            case "m+":
                return new M_Plus();
            case "m-":
                return new M_Minus();
            case "mc":
                return new MClear();
            case "mr":
                return new MRecall();
            case "ms":
                return new MSet();
            case "abs":
                return new Absolute();
            case "^":
                return new AExpB();
            case "ceil":
                return new Ceiling();
            case "floor":
                return new Floor();
            case "c":
                return new Combination();
            case "exp":
                return new Exp();
            case "!":
                return new Factorial();
            case "log10":
                return new Log10();
            case "log":
                return new Log();
            case "%":
                return new Percentage();
            case "p":
                return new Permutation();
            case "sqrt":
                return new SquareRoot();
            case "√":
                return new SquareRoot();
            case "sin":
                return new Sin();
            case "cos":
                return new Cos();
            case "tan":
                return new Tan();
            case "cosec":
                return new Cosec();
            case "sec":
                return new Sec();
            case "cot":
                return new Cot();
            case "asin":
                return new SinInverse();
            case "acos":
                return new CosInverse();
            case "atan":
                return new TanInverse();
            case "acosec":
                return new CosecInverse();
            case "asec":
                return new SecInverse();
            case "acot":
                return new CotInverse();
            default: return null;
        }

    }
}
