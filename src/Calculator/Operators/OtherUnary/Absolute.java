package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Absolute extends Unary {

	public Absolute(){
		firstOperand = null;
	}
	
	public Absolute(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.abs(Double.parseDouble(super.firstOperand)));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}
