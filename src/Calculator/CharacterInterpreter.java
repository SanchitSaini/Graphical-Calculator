package Calculator;

import java.util.Stack;

import Calculator.Operators.Operator;
import Calculator.Operators.Others.Percentage;


public class CharacterInterpreter {

    private Stack<String> valuesStack;
    private Stack<String> operatorStack;

    private InputType inputType;

    private Operator operator;

    private boolean isExpression;

    public static final String[] variableBlackList = {"acos", "asin", "atan", "ceil", "cos", "exp", "floor", "log", "log10", "log2", "sin", "sqrt", "tan", "cot", "sec", "cosec"};


    public void CharacterInterpreter() {
    }

    public Stack getValuesStack() {
        return valuesStack;
    }

    public void pushElementToStack(String input) {

        if (input.equals("e") || input.equals("π"))
        {
            valuesStack.push(input);
            return;
        }

        if ((isNumeric(valuesStack.peek()) && isNumeric(input))  ||  (checkString(input) && checkString(valuesStack.peek()))) {
            String a = valuesStack.pop();
            input = a + input;
        }

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

    public void compute(String input_str) throws Exception {

        String input = input_str;

        splitString(input);



    }

    public boolean hasPrecedence(String op1,  String op2) {
        if (getPriority(op1)>getPriority(op2))
            return true;
        return false;
    }

    public void applyOperator() {
    }

    public void checkOperatorType() {

    }

    public void saveResultToSequence() {
    }


    private boolean checkString(String st)
    {

        if (st.matches("[a-zA-z]+"))
            return true;
        return false;
    }

    private boolean checkNumber(String st)
    {

        if (st.matches("[0-9]"))
            return true;
        return false;
    }

    private int getPriority(String op)
    {
        if(op.equals("*") || op.equals("/") || op.equals("% "))
            return 1;
        else if(op.equals("+") || op.equals("-"))
            return 2;
        else if(op.equals("="))
            return 3;
        else
            return Integer.MIN_VALUE;
    }

    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private void splitString(String input)
    {

        valuesStack.empty();
        operatorStack.empty();



        while(input.length()!=0)
        {
            for (String s:variableBlackList)
            {
                if (input.toLowerCase().startsWith(s))
                {
                    if (input.charAt(s.length())!='(')
                    {
                        ErrorModule.displayError("Wrong format: Expected '(' after " + s);
                        return;
                    }

                    operatorStack.push(s);
                    operatorStack.push("(");
                    input = input.substring(s.length()+1);
                }
            }

            if (input.charAt(0)=='+' || input.charAt(0)=='-' || input.charAt(0)=='*' || input.charAt(0)=='/' || input.charAt(0)=='%' || input.charAt(0)=='^')
            {
                if (!Character.isDigit(input.charAt(1)) && !Character.isLetter(input.charAt(1)))
                {
                    ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
                    return;
                }
                operatorStack.push(input.substring(0, 1));
                input = input.substring(1);
            }

            else {
                pushElementToStack(input.substring(0, 1));
                input = input.substring(1);
            }

        }
    }
}