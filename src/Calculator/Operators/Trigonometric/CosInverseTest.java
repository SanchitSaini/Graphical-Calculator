package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.AngleNotation;

public class CosInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Trigonometric.setAngleType(AngleNotation.RADIANS);
		CosInverse obj = new CosInverse("100");
		String result = String.valueOf(Math.acos(Math.toRadians(100)));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Trigonometric.setAngleType(AngleNotation.DEGREES);
		CosInverse obj = new CosInverse("60");
		String result = String.valueOf(Math.acos(Math.toRadians(60)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		CosInverse obj = new CosInverse("");
		assertEquals(null,obj.evaluate());
	}

}
