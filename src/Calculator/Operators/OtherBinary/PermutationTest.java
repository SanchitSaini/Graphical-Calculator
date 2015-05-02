package Calculator.Operators.OtherBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void testEvaluatePass() {
		Permutation obj = new Permutation("4","2");
//		System.out.println(obj.evaluate());
		assertEquals("12.0",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Permutation obj = new Permutation("xyz","3");
//		System.out.println(obj.evaluate());
		assertEquals(null,obj.evaluate());
	}

}
