package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CosecInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		CosecInverse obj = new CosecInverse("50");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		CosecInverse obj = new CosecInverse("30");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		CosecInverse obj = new CosecInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
