package Calculator.Operators.OtherUnary;

import Calculator.Operators.Operator;

public abstract class Unary extends Operator{
	
	protected String firstOperand;
	
	public abstract String evaluate();

	public void setOperands(String[] operands)
	{
		firstOperand = operands[0];
	}
	
	public int getNumArguments()
	{
		return 1;
	}
	
}
