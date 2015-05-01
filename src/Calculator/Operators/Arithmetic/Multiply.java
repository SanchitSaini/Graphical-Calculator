package Calculator.Operators.Arithmetic;

import Calculator.ErrorModule;

import java.util.logging.Logger;

/***
 * This class implements the multiplication operator
 */
public class Multiply extends Arithmetic {

	public Multiply(){
		firstOperand = null;
		secondOperand = null;
	}
	
	public Multiply(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			//Convert the strings to float
			Float first_op = Float.parseFloat(super.firstOperand);
			Float second_op = Float.parseFloat(super.secondOperand);
			//Compute the multiplication
			result = (double) first_op * second_op;
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