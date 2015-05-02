package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationTest {

	@Test
	public void testEvaluatePass() {
		Combination obj = new Combination("5","2");
//		System.out.println(obj.evaluate());
		assertEquals("10.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		AExpB obj = new AExpB("2","c");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
