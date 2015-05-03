package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class SinTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Sin obj = new Sin("10");
		String result = String.valueOf(Math.sin(Math.toRadians(10)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		Sin obj = new Sin("90");
		String result = String.valueOf(Math.sin(Math.toRadians(90)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Sin obj = new Sin("v");
		assertEquals(null,obj.evaluate());
	}

}
