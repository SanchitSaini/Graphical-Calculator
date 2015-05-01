package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class AExpB extends More_Function_Families {

	public AExpB(String A, String B) {
		super.firstOperand = A;
		super.secondOperand = B;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(Double.parseDouble(super.firstOperand),Double.parseDouble(super.secondOperand)));
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
