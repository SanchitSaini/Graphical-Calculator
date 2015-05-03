package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class CosTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Cos obj = new Cos("55");
		String result = String.valueOf(Math.cos(Math.toRadians(55)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		Cos obj = new Cos("130");
		String result = String.valueOf(Math.cos(Math.toRadians(130)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cos obj = new Cos(" ");
		assertEquals(null,obj.evaluate());
	}
}
