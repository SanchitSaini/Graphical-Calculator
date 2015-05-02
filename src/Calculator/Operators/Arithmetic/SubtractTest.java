package Calculator.Operators.Arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubtractTest {

	@Test
	public void testEvaluatePass() {
		Subtract obj = new Subtract("3", "50");
		assertEquals("-47.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Subtract obj = new Subtract("c","0");
		assertEquals(null,obj.evaluate());
	}

}
