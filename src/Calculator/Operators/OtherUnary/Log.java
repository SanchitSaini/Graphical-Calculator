package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Log extends Unary {

	public Log(){
		firstOperand = null;
	}
	
	public Log(String number) {
		super.firstOperand = number;
	}
  
	public String evaluate() {
		try {
			//Parse the number into Double
			Double firstOp = Double.parseDouble(super.firstOperand);
			//Check if the number is 0 and return NaN if it is
			if(Double.compare(firstOp,0) <= 0) {
				return String.valueOf(Double.NaN);
			}
			//Check if the number is positive and return its log if it is
			else {
				return String.valueOf(Math.log(Double.parseDouble(super.firstOperand)));
			}
			
		}
		catch(Exception e) {
			//Display an error message
            ErrorModule.displayError("Error. Please try again.");
            //Log the error
            Logger.getLogger(e.getMessage());
            //Return null
            return null;
		}
	}
}