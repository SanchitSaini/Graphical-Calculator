package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Square extends Unary {

	public Square(){
		firstOperand = null;
	}
	
	public Square(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(Double.parseDouble(super.firstOperand),2));
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
