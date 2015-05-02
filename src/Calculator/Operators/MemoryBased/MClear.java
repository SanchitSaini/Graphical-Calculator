package Calculator.Operators.MemoryBased;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to clear the memory location 
 */
public class MClear extends Memory {

	public MClear() {
		super.setMemoryData(String.valueOf(0.0));
	}
	
	@Override
	public int getNumArguments()
	{
		return 0;
	}


    @Override
    public void setOperands(String[] operands) {
        throw new UnsupportedOperationException("setOperands not supported for MClear");
    }

    /**
	 * This function will clear the memory. 
	 * @return true/false as String, based on the success of clearing operation
	 */
	public String evaluate() {
		try {
			
			if(super.getMemoryData().equals(null)) {
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the problem that memory is null
				Logger.getLogger("memory is null in MClear");
				//Return null
				return null;
			}
			else {
				//Check if memory has been cleared
				if(super.getMemoryData().equals(String.valueOf(0.0))) {
					//return true if yes
					return String.valueOf(true);
				}
				else {
					//return null
					return null;
				}
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