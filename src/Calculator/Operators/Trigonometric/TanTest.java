package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class TanTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Tan obj = new Tan("180");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Tan obj = new Tan("45");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Tan obj = new Tan("v");
		assertEquals(null,obj.evaluate());
	}

}
