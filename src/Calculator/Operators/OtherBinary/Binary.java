package Calculator.Operators.OtherBinary;

import Calculator.Operators.Operator;

public abstract class Binary extends Operator{

	protected String firstOperand;
	protected String secondOperand;
	
	public abstract String evaluate();
	
	public void setOperands(String[] operands)
	{
		firstOperand = operands[0];
		secondOperand = operands[1];
	}
	
	public int getNumArguments()
	{
		return 2;
	}
}
