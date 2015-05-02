package Calculator.Operators.OtherBinary;

import java.util.logging.Logger;

public class AExpB extends Binary {

	
	public AExpB(){
		firstOperand = null;
		secondOperand = null;
	}
	
	public AExpB(String A, String B) {
		super.firstOperand = A;
		super.secondOperand = B;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(Double.parseDouble(super.firstOperand),Double.parseDouble(super.secondOperand)));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}
