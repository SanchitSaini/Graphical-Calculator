package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		SecInverse obj = new SecInverse("45");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		SecInverse obj = new SecInverse("35");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		SecInverse obj = new SecInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
