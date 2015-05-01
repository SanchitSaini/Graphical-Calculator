package Calculator.Operators.MemoryBased;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to add a value to the value stored in the memory
 */
public class M_Plus extends Memory {

	private String valueToAdd;
	
	public M_Plus(String valueToAdd) {
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
			if(super.getMemoryData().equals(null)) {
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the problem that memory is null
				Logger.getLogger("memory is null in M_Plus");
				//Return null
				return null;
			}
			else {
				Float memData = Float.parseFloat(super.getMemoryData());
				//If valid, perform the subtraction
				result = memData + Float.parseFloat(this.valueToAdd);
				//return result;
				return result.toString();
			}
		}
        catch(Exception e)
        {
            //Display an error message
            ErrorModule.displayError("Error. Please try again.");
            //Log the error
            Logger.getLogger(e.getMessage());
            //Return null
            return null;
        }
	}
}