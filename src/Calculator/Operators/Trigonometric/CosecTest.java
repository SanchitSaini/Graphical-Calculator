package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class CosecTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Cosec obj = new Cosec("40");
		String result = String.valueOf(1/Math.sin(Math.toRadians(40)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		Cosec obj = new Cosec("20");
		String result = String.valueOf(1/Math.sin(Math.toRadians(20)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cosec obj = new Cosec("v");
		assertEquals(null,obj.evaluate());
	}

}
