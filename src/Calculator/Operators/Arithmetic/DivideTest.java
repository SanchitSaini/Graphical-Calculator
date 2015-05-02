package Calculator.Operators.Arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTest {

	@Test
	public void testEvaluatePass() {
		Divide obj = new Divide("300", "50");
		assertEquals("6.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Divide obj = new Divide("c","0");
		assertEquals(null,obj.evaluate());
	}

}
