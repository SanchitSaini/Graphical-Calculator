package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCMTest {

	@Test
	public void testEvaluatePass() {
		LCM obj = new LCM("200","150");
//		System.out.println(obj.evaluate());
		assertEquals("50.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		LCM obj = new LCM("2","");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
