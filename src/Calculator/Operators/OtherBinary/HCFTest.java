package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class HCFTest {

	@Test
	public void testEvaluatePass() {
		HCF obj = new HCF("100","20");
//		System.out.println(obj.evaluate());
		assertEquals("20",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		HCF obj = new HCF("100","c");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
