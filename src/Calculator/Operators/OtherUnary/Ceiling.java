package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Ceiling extends Unary {

	public Ceiling(){
		firstOperand = null;
	}
	
	public Ceiling(String number) {
		super.firstOperand = number;
	}

	public String evaluate() {
		try {
			//evaluate the ceiling of number and return the result
			return String.valueOf(Math.ceil(Double.parseDouble(super.firstOperand)));
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
