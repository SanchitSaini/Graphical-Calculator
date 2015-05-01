package Calculator.Operators.Arithmetic;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * Class to perform subtraction
 */
public class Subtract extends Arithmetic {

	public Subtract(){
		firstOperand = null;
		secondOperand = null;
	}
	
	public Subtract(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			//Convert the strings to float values
			Double first_op = Double.parseDouble(super.firstOperand);
			Double second_op = Double.parseDouble(super.secondOperand);
			//Perform the subtraction
			result = first_op - second_op;
			//Return the result
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