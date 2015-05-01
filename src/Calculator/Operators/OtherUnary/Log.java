package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Log extends Unary {

	public Log(){
		firstOperand = null;
	}
	
	public Log(String number) {
		super.firstOperand = number;
	}
  
	public String evaluate() {
		try {
			//Parse the number into Double
			Double firstOp = Double.parseDouble(super.firstOperand);
			//Check if the number is 0 and return NaN if it is
			if(Double.compare(firstOp,0) == 0) {
				return String.valueOf(Double.NaN);
			}
			//Check if the number is positive and return its log if it is
			else if(Double.parseDouble(super.firstOperand) > 0) {
				return String.valueOf(Math.log(Double.parseDouble(super.firstOperand)));
			}
			//Return negative infinity as log of negative numbers is negative infinity
			else {
				return String.valueOf(Double.NEGATIVE_INFINITY);
			}
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}