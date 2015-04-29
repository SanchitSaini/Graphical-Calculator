package Calculator.Operators.Arithmetic;

import java.util.logging.Logger;

public class Add extends Arithmetic {

	public Add(String firstOperand, String secondOperand){
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
		
	}
	
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			Float first_op = Float.parseFloat(firstOperand);
			Float second_op = Float.parseFloat(secondOperand);
			result = (double) first_op + second_op;
			return result.toString();
		}
		catch (Exception e) {
			Logger.getLogger(e.getMessage());
			return null;
		}
	}
	
	
}