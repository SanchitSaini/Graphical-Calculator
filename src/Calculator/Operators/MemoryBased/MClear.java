package Calculator.Operators.MemoryBased;

/***
 * Class to clear the memory location 
 */
public class MClear extends Memory {

	MClear() {
		super.memoryData = String.valueOf(0.0);
	}
	
	/**
	 * This function will clear the memory. 
	 * @return true/false as String, based on the success of clearing operation
	 */
	public String evaluate() {
		if(super.memoryData.equals(String.valueOf(0.0))) {
			return String.valueOf(true);
		}
		else {
			return String.valueOf(false);
		}
	}
}