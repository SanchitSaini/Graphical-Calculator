package Calculator;

import java.util.Stack;

import Calculator.Operators.Operator;
import Calculator.Operators.OperatorFactory;


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

    public void pushElementToStack(String input) {

        if (input.equals("e") || input.equals("π"))
        {
            valuesStack.push(input);
            return;
        }

        if (!valuesStack.isEmpty())
        {
            if ((isNumeric(valuesStack.peek()) && isNumeric(input))  ||  (checkString(input) && checkString(valuesStack.peek()))) {
                String a = valuesStack.pop();
                input = a + input;
            }
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

    public String compute(String input_str) throws Exception {

        String input = input_str.toLowerCase();


        valuesStack = new Stack<String>();
        operatorStack = new Stack<String>();



        for (int i=0; i<input.length(); i++)
        {
//            if (input[i].equals)
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
                    continue;
                }
            }

            if (isNumeric(input.substring(0, 1)))
            {
                StringBuilder sb = new StringBuilder();
                sb.append(input.substring(0,1));
                if (input.length()==1)
                {
                    input = "";
                    continue;
                }
                else
                    input = input.substring(1);
                while (isNumeric(input.substring(0, 1)))
                {
                    sb.append(input.substring(0,1));
                    if (input.length()==1)
                    {
                        input = "";
                        break;
                    }
                    else
                        input = input.substring(1);
                }

                pushElementToStack(sb.toString());
//                input = input.substring(1);
                continue;
            }

            else if (input.substring(0,1)=="(")
            {
                pushElementToStack(input.substring(0,1));
                if (input.length()==1)
                {
                    input = "";
                }
                else
                    input = input.substring(1);
                continue;
            }
            else if (input.charAt(0)==')')
            {
                while (operatorStack.peek()!="(")
                {
                    evaluate();
                }
                popElementFromStack(operatorStack);
                continue;
            }

            else if (input.charAt(0)=='+' || input.charAt(0)=='-' || input.charAt(0)=='*' || input.charAt(0)=='/' || input.charAt(0)=='%' || input.charAt(0)=='^')
            {
                if (!Character.isDigit(input.charAt(1)) && !Character.isLetter(input.charAt(1)))
                {
                    ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
                    return null;
                }
                while (!operatorStack.isEmpty() && hasPrecedence(operatorStack.peek(), input.substring(0, 1)))
                {

                    evaluate();
                }
                System.out.println("pushing " + input.substring(0, 1));
                operatorStack.push(input.substring(0, 1));
                if (input.length()==1)
                {
                    input = "";
                }
                else
                    input = input.substring(1);
                continue;
            }

            else if (input.substring(0,1).equals("e") || input.substring(0,1).equals("π")) {
                valuesStack.push(input.substring(0,1));
                if (input.length()==1)
                {
                    input = "";
                }
                else
                    input = input.substring(1);
                continue;
            }

            else if (checkString(input.substring(0,1))){
                StringBuilder sb = new StringBuilder();
                sb.append(input.substring(0,1));
                if (input.length()==1)
                {
                    input = "";
                }
                else
                    input = input.substring(1);
                while (checkString(input.substring(0, 1)))
                {
                    sb.append(input.substring(0,1));
                    if (input.length()==1)
                    {
                        input = "";
                        break;
                    }
                    else
                        input = input.substring(1);
                }

                pushElementToStack(sb.toString());
//                input = input.substring(1);
                continue;
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

        if (st.matches("[a-zA-z]"))
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
        if (op.equals("/") || op.equals("% "))
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

        op.setOperands(operands);

        pushElementToStack(op.evaluate());
    }


    public static void main(String[] args) throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();

        System.out.println(c.compute("10+2*6"));
    }
}