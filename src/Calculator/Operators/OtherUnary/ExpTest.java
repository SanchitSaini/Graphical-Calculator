package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpTest {

	@Test
	public void testEvaluatePass1() {
		Exp obj = new Exp("3");
//		System.out.println(obj.evaluate());
		String result = String.valueOf(Math.exp(3));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		Exp obj = new Exp("0");
//		System.out.println(obj.evaluate());
		String result = String.valueOf(Math.exp(0));
		assertEquals(result,obj.evaluate());
	}

	@Test
	public void testEvaluateFail() {
		Exp obj = new Exp("x");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}


}
