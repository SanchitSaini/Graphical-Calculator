package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class PercentageTest {

	@Test
	public void testEvaluatePass() {
		Percentage obj = new Percentage("10","20");
//		System.out.println(obj.evaluate());
		assertEquals("50.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Percentage obj = new Percentage("x","");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
