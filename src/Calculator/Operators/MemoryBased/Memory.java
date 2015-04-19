package Calculator.Operators.MemoryBased;

import Calculator.Operators.Operator;

/***
 * Interface for all memory based operations
 */
public abstract class Memory extends Operator {

	String memoryData;
	
	/**
	 * Performs action on memory and returns whether the operation was performed successfully
	 * @return the result of the action was performed 
	 */
	public abstract String evaluate();
	
}