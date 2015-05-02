package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class CeilingTest {

	@Test
	public void testEvaluatePass1() {
		Ceiling obj = new Ceiling("2");
//		System.out.println(obj.evaluate());
		assertEquals("2.0",obj.evaluate());
	}

	@Test
	public void testEvaluatePass2() {
		Ceiling obj = new Ceiling("2.3");
//		System.out.println(obj.evaluate());
		assertEquals("3.0",obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Ceiling obj = new Ceiling("c");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
