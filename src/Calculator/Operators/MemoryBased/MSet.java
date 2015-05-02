package Calculator.Operators.MemoryBased;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to store a value to the memory location 
 */
public class MSet extends Memory {

	private String valueToSet;
	
	public MSet()
	{
		valueToSet = null;
	}
	
	public MSet(String valueToSet) {
		this.valueToSet = valueToSet;
	}
	
	public void setOperands(String[] operands){
		this.valueToSet = operands[0];
	}
	
	/*
	 * This function stores the parameter to the memory
	 * @param value to be stored to memory
	 * @return true/false as String, based on whether the value was stored to memory 
	 */
	public String evaluate() {
		try {
			// Check if memory location isn't null
			if(!super.getMemoryData().equals(null)) {
				//If not null, store the value to location
				super.setMemoryData(this.valueToSet);
				//return "true"
				return String.valueOf(true);
			}
			else {
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the problem that memory is null
				Logger.getLogger("memory is null in MSet");
				//Else, return null
				return null;
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