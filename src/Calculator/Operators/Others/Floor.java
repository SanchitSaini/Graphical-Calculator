package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Floor extends More_Function_Families {

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