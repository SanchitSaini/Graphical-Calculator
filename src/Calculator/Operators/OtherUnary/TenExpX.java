package Calculator.Operators.OtherUnary;

import java.util.logging.Logger;

public class TenExpX extends Unary {

	public TenExpX(){
		firstOperand = null;
	}
	
	public TenExpX(String x) {
		super.firstOperand = x;
	}

	public String evaluate() {
		try {
			//Return the computation
			return String.valueOf(Math.pow(10,Double.parseDouble(super.firstOperand)));
		}
		catch(Exception e) {
			//Log the exception
			Logger.getLogger(e.getMessage());
			//Return string value of false
			return String.valueOf(false);
		}
	}
}
