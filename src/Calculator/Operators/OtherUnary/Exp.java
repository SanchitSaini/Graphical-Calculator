package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class Exp extends Unary {

	public Exp(){
		firstOperand = null;
	}
	
	public Exp(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.exp(Double.parseDouble(super.firstOperand)));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}


}