package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

import Calculator.ErrorModule;


public class Factorial extends Unary {

	public Factorial(){
		firstOperand = null;
	}
	
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
		catch(Exception e) {
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