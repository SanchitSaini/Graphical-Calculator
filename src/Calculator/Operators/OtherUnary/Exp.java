package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Exp extends Unary {

	public Exp(){
		firstOperand = null;
	}
	
	public Exp(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.exp(Double.parseDouble(super.firstOperand)));
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