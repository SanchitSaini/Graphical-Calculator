package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Ceiling extends More_Function_Families {

	public Ceiling(String number) {
		super.firstOperand = number;
	}

	public String evaluate() {
		try {
			//evaluate the ceiling of number and return the result
			return String.valueOf(Math.ceil(Double.parseDouble(super.firstOperand)));
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
