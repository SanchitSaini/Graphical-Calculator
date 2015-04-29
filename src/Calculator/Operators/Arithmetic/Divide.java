package Calculator.Operators.Arithmetic;

import java.util.logging.Logger;

class Divide extends Arithmetic {

	Divide(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	@Override
	public String evaluate() {
		Float result = (float) 0.0;
		try {
			Float firstOpAsFloat = Float.parseFloat(super.firstOperand);
		    Float secondOpAsFloat = Float.parseFloat(super.secondOperand);
		    if(Float.compare(0,secondOpAsFloat) == 0) {
				throw new ArithmeticException();
			}
			result = firstOpAsFloat/secondOpAsFloat;
			return result.toString();
		}
		catch (ArithmeticException ae) {
			Logger.getLogger("Divide by zero error");
			return null;
		}
	}
}