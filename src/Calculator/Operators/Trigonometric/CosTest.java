package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CosTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		Cos obj = new Cos("55");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		Cos obj = new Cos("130");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Cos obj = new Cos(" ");
		assertEquals(null,obj.evaluate());
	}
}
