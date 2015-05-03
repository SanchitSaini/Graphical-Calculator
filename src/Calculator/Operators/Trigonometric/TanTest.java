package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class TanTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Tan obj = new Tan("180");
		String result = String.valueOf(Math.tan(Math.toRadians(180)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		Tan obj = new Tan("45");
		String result = String.valueOf(Math.tan(Math.toRadians(45)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Tan obj = new Tan("v");
		assertEquals(null,obj.evaluate());
	}

}
