package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;


public class AbsoluteTest {

	@Test
	public void testEvaluatePass1() {
		Absolute obj = new Absolute("100");
//		System.out.println(obj.evaluate());
		assertEquals("100.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		Absolute obj = new Absolute("-50");
//		System.out.println(obj.evaluate());
		assertEquals("50.0",obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Absolute obj = new Absolute("");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
