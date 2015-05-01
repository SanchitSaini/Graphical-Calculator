package Calculator.Operators.MemoryBased;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to get the value from the memory location 
 */
public class MRecall extends Memory {

	public MRecall() {
		//this.valueToReturn = super.memoryData;
	}
	/**
	 * This function will clear the memory. 
	 * @return true/false as String, based on the success of clearing operation
	 */
	public String evaluate() {
		try {
			//load the value from the memory location
			if(super.getMemoryData().equals(null)) {
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the problem that memory is null
				Logger.getLogger("memory is null in MRecall");
				//return null if error encountered
				return null;
			}
			else {
				//return the value if done successfully
				return super.getMemoryData().toString();
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