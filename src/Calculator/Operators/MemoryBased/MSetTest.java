package Calculator.Operators.MemoryBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class MSetTest {

	@Test
	public void testEvaluatePass() {
		MSet obj = new MSet("100");
		assertEquals("true",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		MSet obj = new MSet("c");
		assertEquals(null,obj.evaluate());
	}

}
