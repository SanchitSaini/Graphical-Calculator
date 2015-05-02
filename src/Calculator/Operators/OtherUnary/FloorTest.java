package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloorTest {

	@Test
	public void testEvaluatePass1() {
		Floor obj = new Floor("5.6");
		assertEquals("5.0",obj.evaluate());
	}

	@Test
	public void testEvaluatePass2() {
		Floor obj = new Floor("5");
		assertEquals("5.0",obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Floor obj = new Floor("x");
		assertEquals(null,obj.evaluate());
	}

}
