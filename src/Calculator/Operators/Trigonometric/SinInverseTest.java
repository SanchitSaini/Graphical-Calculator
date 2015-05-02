package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		SinInverse obj = new SinInverse("120");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		SinInverse obj = new SinInverse("30");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		SinInverse obj = new SinInverse("v");
		assertEquals(null,obj.evaluate());
	}

}
