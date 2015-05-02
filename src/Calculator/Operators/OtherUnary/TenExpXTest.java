package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;


public class TenExpXTest {

	@Test
	public void testEvaluatePass() {
		TenExpX obj = new TenExpX("3");
		assertEquals("1000.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		TenExpX obj = new TenExpX("c");
		assertEquals(null,obj.evaluate());
	}

}
