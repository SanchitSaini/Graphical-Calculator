package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class CotTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Cot obj = new Cot("50");
		String result = String.valueOf(1/Math.tan(Math.toRadians(50)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		Cot obj = new Cot("30");
		String result = String.valueOf(1/Math.tan(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cot obj = new Cot("v");
		assertEquals(null,obj.evaluate());
	}

}
