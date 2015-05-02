package Calculator.Operators;

/***
 * Abstract class for operators
 * @version 1
 */
public abstract class Operator {
	
	/**
	 * This function will perform an operation using the operator
	 * @return evaluated value
	 */
	public abstract String evaluate();
    public abstract int getNumArguments();
    public abstract void setOperands(String[] operands);


}