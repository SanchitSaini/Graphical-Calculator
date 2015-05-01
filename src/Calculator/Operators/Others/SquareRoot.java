package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class SquareRoot extends More_Function_Families {

	public SquareRoot(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.sqrt(Double.parseDouble(super.firstOperand)));
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
