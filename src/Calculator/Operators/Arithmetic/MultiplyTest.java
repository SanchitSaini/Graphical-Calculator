package Calculator.Operators.Arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public void testEvaluatePass() {
		Multiply obj = new Multiply("3", "50");
		assertEquals("150.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Multiply obj = new Multiply("c","0");
		assertEquals(null,obj.evaluate());
	}

}
