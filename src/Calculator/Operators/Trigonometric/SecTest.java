package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class SecTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Sec obj = new Sec("60");
		String result = String.valueOf(1/Math.cos(Math.toRadians(60)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		Sec obj = new Sec("70");
		String result = String.valueOf(1/Math.cos(Math.toRadians(70)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Sec obj = new Sec("v");
		assertEquals(null,obj.evaluate());
	}

}
