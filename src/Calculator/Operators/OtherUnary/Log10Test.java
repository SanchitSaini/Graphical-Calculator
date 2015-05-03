package Calculator.Operators.OtherUnary;

import static org.junit.Assert.*;

import org.junit.Test;

public class Log10Test {

	@Test
	public void testEvaluatePass1() {
		Log10 obj = new Log10("2");
		String result = String.valueOf(Math.log10(2));
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail1() {
		Log10 obj = new Log10("0");
		String result = String.valueOf(Double.NaN);
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail2() {
		Log10 obj = new Log10("-1");
		String result = String.valueOf(Double.NaN);
		assertEquals(result,obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail3() {
		Log10 obj = new Log10("x");
		assertEquals(null,obj.evaluate());
	}

}
