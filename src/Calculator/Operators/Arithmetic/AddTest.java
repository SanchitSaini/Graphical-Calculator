package Calculator.Operators.Arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;


public class AddTest {

	@Test
	public void testEvaluatePass() {
		Add obj = new Add("3", "50");
		assertEquals("53.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Add obj = new Add("c","0");
		assertEquals(null,obj.evaluate());
	}

}
