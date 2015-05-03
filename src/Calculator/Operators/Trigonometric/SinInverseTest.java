package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class SinInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		SinInverse obj = new SinInverse("120");
		String result = String.valueOf(Math.asin(120));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		
		SinInverse obj = new SinInverse("30");
		String result = String.valueOf(Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		SinInverse obj = new SinInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
