package Calculator.Operators.Trigonometric;

import Calculator.Operators.Operator;

public abstract class Trigonometric extends Operator {

	private static AngleNotation angleType;
	protected String angleValue;

	public Trigonometric() {
		setAngleType(AngleNotation.DEGREES);
	}
	
	public abstract String evaluate();

	/**
	 * Function to get the angle type 
	 * @return Angle type (degree or radians)
	 */
	protected static AngleNotation getAngleType() {
		return angleType;
	}

	/**
	 * Function to set the angle type
	 * @param angleType Angle type to be set
	 */
	protected static void setAngleType(AngleNotation angleType) {
		Trigonometric.angleType = angleType;
	}
	
	public void setOperands(String[] operands)
	{
		angleValue = operands[0];
	}
	
	public int getNumArguments()
	{
		return 1;
	}
}