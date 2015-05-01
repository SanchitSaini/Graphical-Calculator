package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;


public class Percentage extends More_Function_Families {

	public Percentage(String number, String total) {
		super.firstOperand = number;
		super.secondOperand = total;
	}

	public String evaluate() {
		try{
			Double secondOp = Double.parseDouble(super.secondOperand);
			
			//If the denominator is 0, return null
			if(secondOp.equals(0.0)) {
				return null;
			}
			
			Double firstOp = Double.parseDouble(super.firstOperand);
			//Compute the percentage
			Double percentage = (Double)((firstOp/secondOp)*100);
			//Return the percentage
			return String.valueOf(percentage);
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