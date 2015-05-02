package Calculator.Operators.MemoryBased;

import Calculator.Operators.Operator;

/***
 * Interface for all memory based operations
 */
public abstract class Memory extends Operator {

    private static String memoryData = String.valueOf(0.0);

//	public  Memory() {
//		this.memoryData = String.valueOf(0.0);
//	}

    /**
     * Performs action on memory and returns whether the operation was performed successfully
     *
     * @return the result of the action was performed
     */
    public abstract String evaluate();

    /**
     * Function to get value in memoryData
     *
     * @return value in memoryData
     */
    static String getMemoryData() {
        return memoryData;
    }

    /**
     * Function to set value of memoryData
     *
     * @param memoryData
     */
    static void setMemoryData(String memoryData) {
        Memory.memoryData = memoryData;
    }

    public int getNumArguments() {
        return 1;
    }

    //public abstract void setOperands(String[] operands);
}