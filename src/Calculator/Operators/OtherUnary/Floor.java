package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Floor extends Unary {

	public Floor(){
		firstOperand = null;
	}
	
	public Floor(String number) {
		super.firstOperand = number;
	}

	public String evaluate() {
		try {
			return String.valueOf(Math.floor(Double.parseDouble(super.firstOperand)));
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