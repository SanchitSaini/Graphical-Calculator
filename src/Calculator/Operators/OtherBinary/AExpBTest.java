package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class AExpBTest {

	@Test
	public void testEvaluatePass() {
		AExpB obj = new AExpB("2","3");
//		System.out.println(obj.evaluate());
		assertEquals("8.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		AExpB obj = new AExpB("2","c");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}


}
