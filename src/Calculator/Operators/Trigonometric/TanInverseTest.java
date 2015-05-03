package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class TanInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		TanInverse obj = new TanInverse("80");
		String result = String.valueOf(Math.atan(Math.toRadians(80)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		TanInverse obj = new TanInverse("30");
		String result = String.valueOf(Math.atan(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		TanInverse obj = new TanInverse("v");
		assertEquals(null,obj.evaluate());
	}

}