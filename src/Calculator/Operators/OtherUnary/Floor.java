package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Floor extends Unary {

	public Floor(){
		firstOperand = null;
	}
	
	public Floor(String number) {
		super.firstOperand = number;
	}

	public String evaluate() {
		try {
			
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
		return String.valueOf(Math.floor(Double.parseDouble(super.firstOperand)));
	}
}