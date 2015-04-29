package Calculator.Operators.MemoryBased;

import java.util.logging.Logger;

/***
 * Class to add a value to the value stored in the memory
 */
public class M_Plus extends Memory {

	private String valueToAdd;
	
	M_Plus(String valueToAdd) {
		this.valueToAdd = valueToAdd;
	}
	
	/**
	 * This function performs an addition to the value in memory
	 * @return result of adding the parameter from the value in memory
	 */
	public String evaluate() {
		Float result = (float) 0.0;
		//Check if value in memory is valid
		try {
			if(super.memoryData.isEmpty()) {
				super.memoryData = String.valueOf(0.0);
			}
			else {
				Float memData = Float.parseFloat(super.memoryData);
				//If valid, perform the subtraction
				result = memData + Float.parseFloat(this.valueToAdd);
				//return result;
				return result.toString();
			}
		}
		catch(Exception e) {
			Logger.getLogger(e.getMessage());
			return null;
		}
		return null;
	}
}