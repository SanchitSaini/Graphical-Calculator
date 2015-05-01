package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;


public class Factorial extends More_Function_Families {

	public Factorial(String number) {
		super.firstOperand = number;
	}
	
	public String evaluate() {
		try {
			//Parse the string as double
			Double number = Double.parseDouble(super.firstOperand);
			if(number < 0.0) {
				return String.valueOf(false);
			}	
			Double factorial = factorial(Math.floor(number));
			return String.valueOf(factorial);
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

	/**
	 * Function to compute the factorial
	 * @param num number whose factorial is to be computed
	 * @return factorial of num
	 */
	public static double factorial(double num) {
		if(num==1)  return 1;
	    else        return num = factorial(num-1)*num;
	}
}