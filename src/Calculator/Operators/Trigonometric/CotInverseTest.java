package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CotInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		CotInverse obj = new CotInverse("70");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		CotInverse obj = new CotInverse("45");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		CotInverse obj = new CotInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
