package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class SecInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		SecInverse obj = new SecInverse("45");
		String result = String.valueOf(1/Math.acos(Math.toRadians(45)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		SecInverse obj = new SecInverse("35");
		String result = String.valueOf(1/Math.acos(Math.toRadians(35)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		SecInverse obj = new SecInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
