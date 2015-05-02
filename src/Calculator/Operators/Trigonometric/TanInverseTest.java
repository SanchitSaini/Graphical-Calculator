package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class TanInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		TanInverse obj = new TanInverse("80");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		TanInverse obj = new TanInverse("30");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		TanInverse obj = new TanInverse("v");
		assertEquals(null,obj.evaluate());
	}

}