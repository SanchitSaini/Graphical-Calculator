package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareRootTest {

	@Test
	public void testEvaluatePass1() {
		SquareRoot obj = new SquareRoot("4");
		String result = String.valueOf(Math.sqrt(4));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail1() {
		SquareRoot obj = new SquareRoot("0");
		String result = String.valueOf(Math.sqrt(0));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail2() {
		SquareRoot obj = new SquareRoot("-1");
		String result = String.valueOf(Math.sqrt(-1));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail3() {
		SquareRoot obj = new SquareRoot("x");
		assertEquals(null,obj.evaluate());
	}

}
