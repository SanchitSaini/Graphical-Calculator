package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Square extends Unary {

	public Square(){
		firstOperand = null;
	}
	
	public Square(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(Double.parseDouble(super.firstOperand),2));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}
