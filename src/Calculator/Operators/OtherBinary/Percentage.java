package Calculator.Operators.OtherBinary;

import java.util.logging.Logger;

import Calculator.ErrorModule;


public class Percentage extends Binary {

	public Percentage(String number, String total) {
		super.firstOperand = number;
		super.secondOperand = total;
	}
	
	public Percentage() {
		firstOperand = null;
		secondOperand = null;
	}

	public String evaluate() {
		try{
			Double secondOp = Double.parseDouble(super.secondOperand);
			
			//If the denominator is 0, return false
			if(secondOp.equals(0.0)) {
				return String.valueOf(false);
			}
			
			Double firstOp = Double.parseDouble(super.firstOperand);
			//Compute the percentage
			Double percentage = (Double)((firstOp/secondOp)*100);
			//Return the percentage
			return String.valueOf(percentage);
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