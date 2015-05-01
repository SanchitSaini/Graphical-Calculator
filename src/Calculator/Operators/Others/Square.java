package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Square extends More_Function_Families {

	public Square(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(Double.parseDouble(super.firstOperand),2));
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
