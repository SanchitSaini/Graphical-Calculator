package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testEvaluatePass() {
		Factorial obj = new Factorial("5");
		assertEquals("120.0",obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Factorial obj = new Factorial("x");
		assertEquals(null,obj.evaluate());
	}

}
