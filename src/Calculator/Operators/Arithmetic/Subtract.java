package Calculator.Operators.Arithmetic;

/***
 * Class to perform subtraction
 */
class Subtract extends Arithmetic {

	Subtract(String firstOperand, String secondOperand) {
		super.firstOperand = firstOperand;
		super.secondOperand = secondOperand;
	}
	@Override
	public String evaluate() {
		Double result = 0.0;
		try {
			Double first_op = Double.parseDouble(super.firstOperand);
			Double second_op = Double.parseDouble(super.secondOperand);
			result = first_op - second_op;
			return result.toString();
		}
		catch (Exception e) {
			return null;
		}
	}
}