package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class Combination extends More_Function_Families {
	  
	/**
	 * Constructor of combination function
	 * @param number_n n of nCr
	 * @param number_r r of nCr
	 */
	public Combination(String number_n, String number_r) {
		  super.firstOperand = number_n;
		  super.secondOperand = number_r;
	}
	  
	public String evaluate() {
		try {
			//Convert strings to float
			Double n = Double.parseDouble(super.firstOperand);
			Double r = Double.parseDouble(super.secondOperand);
			
			//If either of the numbers are negative, return null
			if((Double.compare(n,0.0) == 0) || (Double.compare(r,0.0) == 0)) {
				return null;
			}
			
			//If not, compute the combinations
			Double combination = factorial(n)/(factorial(n-r)*factorial(r));
			//Return string value of the computation
			return String.valueOf(combination);
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