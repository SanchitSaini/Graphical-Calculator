package Calculator.Operators.Trigonometric;

import static org.junit.Assert.*;

import org.junit.Test;

public class CosInverseTest {

	@Test
	public void testEvaluatePass1() {
		//In radians
		CosInverse obj = new CosInverse("100");
		String result = String.valueOf(1/Math.asin(50));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		//In degree
		CosInverse obj = new CosInverse("60");
		String result = String.valueOf(1/Math.asin(Math.toRadians(30)));;
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		CosInverse obj = new CosInverse("");
		assertEquals(null,obj.evaluate());
	}

}
