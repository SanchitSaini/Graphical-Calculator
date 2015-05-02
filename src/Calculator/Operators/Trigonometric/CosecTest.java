package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CosecTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Cosec obj = new Cosec("40");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Cosec obj = new Cosec("20");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cosec obj = new Cosec("v");
		assertEquals(null,obj.evaluate());
	}

}
