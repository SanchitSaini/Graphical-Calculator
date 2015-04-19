package Calculator.Operators.MemoryBased;

/***
 * Class to get the value from the memory location 
 */
public class MRecall extends Memory {

	MRecall() {
		//this.valueToReturn = super.memoryData;
	}
	/**
	 * This function will clear the memory. 
	 * @return true/false as String, based on the success of clearing operation
	 */
	public String evaluate() {
		//load the value from the memory location
		if(super.memoryData.isEmpty()) {
			//return null if error encountered
			return null;
		}
		else {
			//return the value if done successfully
			return super.memoryData.toString();
		}
	}
}