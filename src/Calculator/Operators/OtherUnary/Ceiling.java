package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Ceiling extends Unary {

	public Ceiling(){
		firstOperand = null;
	}
	
	public Ceiling(String number) {
		super.firstOperand = number;
	}

	public String evaluate() {
		try {
			//evaluate the ceiling of number and return the result
			return String.valueOf(Math.ceil(Double.parseDouble(super.firstOperand)));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}
