package Calculator.Operators.Arithmetic;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Divide extends Arithmetic {

	public Divide(){
		firstOperand = null;
		secondOperand = null;
	}
	
	public Divide(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	@Override
	public String evaluate() {
		Float result = (float) 0.0;
		try {
			
			Float firstOpAsFloat = Float.parseFloat(super.firstOperand);
			Float secondOpAsFloat = Float.parseFloat(super.secondOperand);
		
			//Check if the denominator is zero
			if(Float.compare(0,secondOpAsFloat) == 0) {
				//If yes, check if the numerator is negative and return string value of negative infinity
				if(Float.compare(firstOpAsFloat,0)<0) {
				return String.valueOf(Float.NEGATIVE_INFINITY);
				}
				//If yes, (else if) check if the numerator is zero and return string value of NaN 
				else if (Float.compare(0,firstOpAsFloat)==0) {
					return String.valueOf(Float.NaN);
				}
				//If yes, (else) return the string value of positive infinity
				else {
					return String.valueOf(Float.POSITIVE_INFINITY);
				}
			}
		
			//Perform the division the denominator isn't zero
			result = firstOpAsFloat/secondOpAsFloat;
			//Return the result of the division
			return result.toString();
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