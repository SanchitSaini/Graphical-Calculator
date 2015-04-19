package Calculator.Operators.Arithmetic;

import Calculator.Operators.Operator;

/**
 * Interface for arithmetic operations
 */
public abstract class Arithmetic extends Operator {
	
	protected String firstOperand;
	protected String secondOperand;
	
	public abstract String evaluate();
	
}