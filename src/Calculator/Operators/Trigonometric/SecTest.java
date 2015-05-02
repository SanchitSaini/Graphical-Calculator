package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Sec obj = new Sec("60");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Sec obj = new Sec("70");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Sec obj = new Sec("v");
		assertEquals(null,obj.evaluate());
	}

}
