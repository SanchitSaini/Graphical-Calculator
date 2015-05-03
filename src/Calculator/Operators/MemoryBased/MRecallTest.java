package Calculator.Operators.MemoryBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class MRecallTest {

	@Test
	public void testEvaluatePass() {
		MSet obj1 = new MSet("200");
		obj1.evaluate();
		MRecall obj2 = new MRecall();
		assertEquals("200.0",obj2.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		MSet obj1 = new MSet("50");
		obj1.evaluate();
		MRecall obj2 = new MRecall();
		assertFalse("30".equals(obj2.evaluate()));
	}


}
