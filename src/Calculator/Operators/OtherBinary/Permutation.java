package Calculator.Operators.OtherBinary;

import java.util.logging.Logger;


public class Permutation extends Binary {

	public Permutation(String number_n, String number_r) {
		  super.firstOperand = number_n;
		  super.secondOperand = number_r;
	}
	
	public Permutation() {
		firstOperand = null;
		secondOperand = null;
	}
	  
	public String evaluate() {
		try {
			Double n = Double.parseDouble(super.firstOperand);
			Double r = Double.parseDouble(super.secondOperand);
			
			//If either of the numbers are negative, return false
			if((Double.compare(n,0.0) == 0) || (Double.compare(r,0.0) == 0)) {
				return String.valueOf(false);
			}
			
			//Compute the permutations
			Double permutation = factorial(n)/(factorial(n-r));
			//Return the computation as a string
			return String.valueOf(permutation);
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
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