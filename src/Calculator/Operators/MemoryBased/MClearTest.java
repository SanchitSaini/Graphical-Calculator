package Calculator.Operators.MemoryBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class MClearTest {

	@Test
	public void testEvaluatePass() {
		MSet obj1 = new MSet("20");
		obj1.evaluate();
		MClear obj2 = new MClear();
		assertEquals("true",obj2.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		MSet obj1 = new MSet("50");
		obj1.evaluate();
		MClear obj2 = new MClear();
		assertEquals("true",obj2.evaluate());
	}

}
