package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class CotInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		CotInverse obj = new CotInverse("70");
		String result = String.valueOf(1/Math.atan(Math.toRadians(70)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		CotInverse obj = new CotInverse("45");
		String result = String.valueOf(1/Math.atan(Math.toRadians(45)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		CotInverse obj = new CotInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
