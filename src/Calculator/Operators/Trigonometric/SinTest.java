package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Sin obj = new Sin("10");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Sin obj = new Sin("90");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Sin obj = new Sin("v");
		assertEquals(null,obj.evaluate());
	}

}
