package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void testEvaluatePass1() {
		Square obj = new Square("2");
		String result = String.valueOf(Math.pow(3,2));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass2() {
		Square obj = new Square("0");
		String result = String.valueOf(Math.pow(0, 2));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluatePass3() {
		Square obj = new Square("-5");
		String result = String.valueOf(Math.pow(-5, 3));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Square obj = new Square("x");
		assertEquals(null,obj.evaluate());
	}

}
