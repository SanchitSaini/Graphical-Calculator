package Calculator.Operators.MemoryBased;

import java.util.logging.Logger;

/***
 * Class to subtract a value from the value stored in memory
 */
public class M_Minus extends Memory {

	private String valueToSubtract;
	
	M_Minus(String valueToSubtract) {
		this.valueToSubtract = valueToSubtract;
	}
	
	/**
	 * This function performs a subtraction to the value in memory
	 * @return result of subtracting the parameter from the value in memory
	 * @throws  
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
				result = memData - Float.parseFloat(this.valueToSubtract);
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