package Calculator.Operators.MemoryBased;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to subtract a value from the value stored in memory
 */
public class M_Minus extends Memory {

	private String valueToSubtract;
	
	public M_Minus()
	{
		valueToSubtract = null;
	}
	
	public M_Minus(String valueToSubtract) {
		this.valueToSubtract = valueToSubtract;
	}
	
	public void setValueToSubtract(String valueToSubtract){
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
			if(super.getMemoryData().equals(null)) {
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the fact that memory is null
				Logger.getLogger("memory is null in M_Minus");
				//Return null
				return null;
			}
			else {
				//System.out.println(super.memoryData);
				Float memData = Float.parseFloat(super.getMemoryData());
				//If valid, perform the subtraction
				result = memData - Float.parseFloat(this.valueToSubtract);
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

    @Override
    public void setOperands(String[] operands) {
        valueToSubtract = operands[0];
    }
}