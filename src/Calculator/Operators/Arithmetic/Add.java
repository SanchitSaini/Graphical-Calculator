package Calculator.Operators.Arithmetic;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Add extends Arithmetic {

	public Add(){
		firstOperand = null;
		secondOperand = null;
	}
	
	public Add(String firstOperand, String secondOperand){
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
		
	}
	
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			//Convert the strings to float
			Float first_op = Float.parseFloat(firstOperand);
			Float second_op = Float.parseFloat(secondOperand);
			//Compute the sum
			result = (double) first_op + second_op;
			//Return the sum
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