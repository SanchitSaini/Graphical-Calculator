package Calculator.Operators.Arithmetic;

import java.util.logging.Logger;

/***
 * This class implements the multiplication operator
 */
class Multiply extends Arithmetic {

	Multiply(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			Float first_op = Float.parseFloat(super.firstOperand);
			Float second_op = Float.parseFloat(super.secondOperand);
			result = (double) first_op * second_op;
			return result.toString();
		}
		catch (Exception e) {
			Logger.getLogger(e.getMessage());
			return null;
		}
	}
}