package Calculator;

import java.util.Stack;

import Calculator.Operators.Operator;
import Calculator.Operators.OperatorFactory;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages_pt_BR;

import java.util.*;


public class CharacterInterpreter {

    private Stack<String> valuesStack;
    private Stack<String> operatorStack;

    private Operator operator;


//    Variable names
    public static final String[] variableBlackList = {"acosec","acos", "asin", "atan", "ceil","cosec", "cos", "exp", "floor", "log10","log", "sin", "sqrt", "tan", "cot", "sec",  "abs", "m+", "m-", "mc", "mr", "ms", "acot", "asec"  };


    public CharacterInterpreter() {
    	operator = null;
    }

    //Function to return the values stack
    public Stack getValuesStack() {
        return valuesStack;
    }

    // Push elements to a stack
    public void pushElementToStack(Stack valuesStack, String input) {

        valuesStack.push(input);
//        compute();
    }

    //opo element from stack and return it
    public String popElementFromStack(Stack<String> inputStack) throws Exception {
        if(inputStack.isEmpty())
        {
            throw new Exception("No element in stack.");
        }

        return inputStack.pop();

    }

    public String peekIntoStack(Stack<String> inputStack) throws Exception {
        if(inputStack.isEmpty())
        {
            throw new Exception("No element in stack.");
        }

        return inputStack.peek();
    }

    //Function to compute the expression as given by the string.
    // This function is called when the User presses '='.
    // Uses tbe Evaluation algorithm for infix notations
    //Returns the final output


    public String compute(String input_str) throws Exception {

//        convert the input string to lower case and make a copy
        String input = input_str.toLowerCase();

//        Initialize both the values and operator stack.
//        Values Stack stores the input numbers and variables.
//        Operator Stack stores all the operators

        valuesStack = new Stack<>();
        operatorStack = new Stack<>();


        //run the loop while the input is not empty
        while(input.length()!=0)
        {
            //Check for spaces in the expression and remove them
            if (input.substring(0,1).equals(" "))
            {
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);
                continue;
            }

            //check if the next object in input is an operator from the operator list
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

            if (input.isEmpty())
                continue;

//          check if the object is a number. Push whole number to Values stack
            else if (isNumeric(input.substring(0, 1)))
            {
                StringBuilder sb = new StringBuilder();
                while (isNumeric(input.substring(0, 1)) || input.charAt(0)=='.')
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

//          Check if the object is a '('. Push it to operator stack
            else if (input.substring(0,1).equals("("))
            {
                pushElementToStack(operatorStack, input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

//          Check if the next object is a ')'.
            else if (input.charAt(0)==')')
            {
//              Evaluate all the operators till you reach the '('
                while (!operatorStack.peek().equals("("))
                {
                    evaluate();
                }

//              Pop '(' from operator stack
                popElementFromStack(operatorStack);
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

//          check if the object is one of the binary operators
            else if (input.charAt(0)=='+' || input.charAt(0)=='-' || input.charAt(0)=='*' || input.charAt(0)=='/' || input.charAt(0)=='%' || input.charAt(0)=='^' || input.substring(0,1).equals("c") || input.substring(0,1).equals("p"))
            {
                if (input.length()>1) {
//                  check if it is surrounded by a digit or variable or bracket. Throw an error if not
                    if (!Character.isDigit(input.charAt(1)) && !Character.isLetter(input.charAt(1)) && input.charAt(1)!='(') {
                        ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
                        return null;
                    }
                }
                else
                {
                    ErrorModule.displayError("Error: Incomplete Expression");
                    return null;
                }

//                While the operator stack is not empty, and the top operator on the
//                operator stack has the same or greater precedence as thisOp, evaluate
//                the operator and push it back
                while (!operatorStack.isEmpty() && hasPrecedence(operatorStack.peek(), input.substring(0, 1)))
                {

                    evaluate();
                }
                System.out.println("pushing " + input.substring(0, 1));

//              Push the current operator into stack
                operatorStack.push(input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

//            Check for Square root operator
            else if (input.substring(0,1).equals("√")) {

                if (input.length()>1) {
                    if (!Character.isDigit(input.charAt(1)) && !Character.isLetter(input.charAt(1)) && input.charAt(1)!='(') {
                        ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
                        return null;
                    }
                }
                else
                {
                    ErrorModule.displayError("Error: Incomplete Expression");
                    return null;
                }

                pushElementToStack(operatorStack, input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

//            Check for factorial
            else if (input.substring(0,1).equals("!")) {

                if (input.length()>1) {
//                    Check if the proceeding object is a number or variable or open parenthesis. Throw error in this case
                    if (Character.isDigit(input.charAt(1)) || Character.isLetter(input.charAt(1)) || input.charAt(1)=='(') {
                        ErrorModule.displayError("Wrong Format: expected number or variable after " + input.charAt(0));
                        return null;
                    }
                }
//                Push '!' into stack
                pushElementToStack(operatorStack, input.substring(0, 1));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }

//            Check if the object is 'e' . Push into Values stack
            else if (input.substring(0,1).equals("e")) {
                pushElementToStack(valuesStack, String.valueOf(Math.E));
                if (input.length()==1)
                    input = "";
                else
                    input = input.substring(1);

            }
//            Check if the object is pi. Push into Values stack
            else if (input.substring(0,1).equals("π")) {
            pushElementToStack(valuesStack, String.valueOf(Math.PI));
                if (input.length() == 1)
                    input = "";
                else
                    input = input.substring(1);

            }

//            Check if the object is a string variable. Push whole into values stack
            else if (checkString(input.substring(0, 1))){
                StringBuilder sb = new StringBuilder();
//                combine variable name till next operator or digit
                while (checkString(input.substring(0, 1))) {
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


//        Evaluate stack till all operators are exhausted
        while (!operatorStack.isEmpty())
        {
            if (operatorStack.peek().equals("("))
            {
                ErrorModule.displayError("Error: Unbalenced Parenthesis");
                return null;
            }
            evaluate();
        }

//      Report error if the Values Stack has more than 1 item left
        if (valuesStack.size()==1 && operatorStack.size()==0)
        {
            return valuesStack.pop();
        }


        return null;

    }

//    Checks the precedence of operators
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

//    Gets the priority level of an operator
    private int getPriority(String op)
    {
        if (op.equals("!")||op.equals("c")||op.equals("p"))
            return 6;
        else if (op.equals("^"))
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

//    Checks if the input is a number or not
    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

//    Evaluates the top operator of stack
    private void evaluate() throws Exception {
        if (operatorStack.isEmpty())
        {
            ErrorModule.displayError("Error, No operators found");
            return;
        }
//        Get the object corresponding to the symbol from the operatorFactory
        Operator op = OperatorFactory.getOperator(operatorStack.pop());

//        Check the number of arguements it needs
        int args = op.getNumArguments();

        String[] operands = new String[args];

//        Get the required number of arguements from Values Stack
        for (int i = 0; i<args; i++)
        {
            if (valuesStack.isEmpty())
            {
                ErrorModule.displayError("Error: Invalid Expression");
                return;
            }
            operands[i] = popElementFromStack(valuesStack);
        }

//        Set the right order for the operands
        Collections.reverse(Arrays.asList(operands));
        op.setOperands(operands);

//        Evaluate the operator and push the output to the Values Stack
        pushElementToStack(valuesStack, op.evaluate());
    }


    public static void main(String[] args) throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();

        System.out.println(c.compute("e^sin(30)"));
    }
}