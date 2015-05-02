package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CotTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Cot obj = new Cot("50");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Cot obj = new Cot("30");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cot obj = new Cot("v");
		assertEquals(null,obj.evaluate());
	}

}
