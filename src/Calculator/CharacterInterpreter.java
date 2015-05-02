package Calculator;

import java.util.Stack;

import Calculator.Operators.Operator;
import Calculator.Operators.OperatorFactory;
import java.util.*;


public class CharacterInterpreter {

    private Stack<String> valuesStack;
    private Stack<String> operatorStack;

    private InputType inputType;

    private Operator operator;

    private boolean isExpression;

    public static final String[] variableBlackList = {"acos", "asin", "atan", "ceil", "cos", "exp", "floor", "log", "log10", "sin", "sqrt", "tan", "cot", "sec", "cosec", "abs", "m+", "m-", "mc", "mr", "ms", "acot", "asec", "acosec", };


    public void CharacterInterpreter() {
    }

    public Stack getValuesStack() {
        return valuesStack;
    }

    public void pushElementToStack(Stack valuesStack, String input) {

        valuesStack.push(input);
//        compute();
    }

    public String popElementFromStack(Stack<String> inputStack) throws Exception {
        if(inputStack.isEmpty())
        {
            throw new Exception("No element in stack.");
        }

        return inputStack.pop();

    }

    public String peakIntoStack(Stack<String> inputStack) throws Exception {
        if(inputStack.isEmpty())
        {
            throw new Exception("No element in stack.");
        }

        return inputStack.peek();
    }

    public String compute(String input_str) throws Exception {

        String input = input_str.toLowerCase();


        valuesStack = new Stack<>();
        operatorStack = new Stack<>();



        while(input.length()!=0)
        {
            if (input.substring(0,1).equals(" "))
            {
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);
                continue;
            }
            for (String s:variableBlackList)
            {
                if (input.toLowerCase().startsWith(s))
                {
                    if (input.charAt(s.length())!='(')
                    {
                        ErrorModule.displayError("Wrong format: Expected '(' after " + s);
                        return null;
                    }

                    operatorStack.push(s);
                    operatorStack.push("(");
                    input = input.substring(s.length()+1);

                }
            }

            if (isNumeric(input.substring(0, 1)))
            {
                StringBuilder sb = new StringBuilder();
                while (isNumeric(input.substring(0, 1)))
                {
                    sb.append(input.substring(0,1));

                    if (input.length()==1) {
                        input = "";
                        break;
                    }
                    else
                        input = input.substring(1);
                }

                pushElementToStack(valuesStack, sb.toString());
//                input = input.substring(1);

            }

            else if (input.substring(0,1).equals("("))
            {
                pushElementToStack(operatorStack, input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }
            else if (input.charAt(0)==')')
            {
                while (!operatorStack.peek().equals("("))
                {
                    evaluate();
                }
                popElementFromStack(operatorStack);
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

            else if (input.charAt(0)=='+' || input.charAt(0)=='-' || input.charAt(0)=='*' || input.charAt(0)=='/' || input.charAt(0)=='%' || input.charAt(0)=='^')
            {
//                if (!Character.isDigit(input.charAt(1)) && !Character.isLetter(input.charAt(1)))
//                {
//                    ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
//                    return null;
//                }
                while (!operatorStack.isEmpty() && hasPrecedence(operatorStack.peek(), input.substring(0, 1)))
                {

                    evaluate();
                }
                System.out.println("pushing " + input.substring(0, 1));
                operatorStack.push(input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

            else if (input.substring(0,1).equals("c") || input.substring(0,1).equals("p")) {
                pushElementToStack(operatorStack, input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

            else if (input.substring(0,1).equals("e")) {
                pushElementToStack(valuesStack, String.valueOf(Math.E));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

            else if (input.substring(0,1).equals("e")) {
                pushElementToStack(valuesStack, String.valueOf(Math.E));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

            else if (input.substring(0,1).equals("π")) {
                pushElementToStack(valuesStack, String.valueOf(Math.PI));
                if (input.length() == 1)
                    input = "";
                else
                    input = input.substring(1);

            }
            else if (checkString(input.substring(0, 1))){
                StringBuilder sb = new StringBuilder();
                while (checkString(input.substring(0, 1)))
                {
                    sb.append(input.substring(0,1));
                    if (input.length()==1) {
                        input = "";
                        break;
                    }
                    else
                        input = input.substring(1);
                }

                pushElementToStack(valuesStack, sb.toString());
//                input = input.substring(1);

            }

        }


        while (!operatorStack.isEmpty())
        {
            evaluate();
        }


        if (valuesStack.size()==1 && operatorStack.size()==0)
        {
            return valuesStack.pop();
        }


        return null;

    }

    public boolean hasPrecedence(String op1,  String op2) {
        return getPriority(op1)>getPriority(op2);

    }

    public void applyOperator() {
    }

    public void checkOperatorType() {

    }

    public void saveResultToSequence() {
    }


    private boolean checkString(String st)
    {

        return st.matches("[a-zA-z]");
    }

    private boolean checkNumber(String st)
    {

        return st.matches("[0-9]");

    }

    private int getPriority(String op)
    {
        if (op.equals("^"))
            return 5;
        else if (op.equals("/") || op.equals("%"))
            return 4;
        else if(op.equals("*"))
            return 3;
        else if(op.equals("+") || op.equals("-"))
            return 2;
        else if(op.equals("="))
            return 1;
        else
            return Integer.MIN_VALUE;
    }

    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private void evaluate() throws Exception {
        if (operatorStack.isEmpty())
        {
            ErrorModule.displayError("Error, No operators found");
            return;
        }
        Operator op = OperatorFactory.getOperator(operatorStack.pop());
        int args = op.getNumArguments();
        String[] operands = new String[args];
        for (int i = 0; i<args; i++)
        {
            if (valuesStack.isEmpty())
            {
                ErrorModule.displayError("Error: Invalid Expression");
                return;
            }
            operands[i] = popElementFromStack(valuesStack);
        }

        Collections.reverse(Arrays.asList(operands));
        op.setOperands(operands);

        pushElementToStack(valuesStack, op.evaluate());
    }


    public static void main(String[] args) throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();

        System.out.println(c.compute("e^sin(30)"));
    }
}