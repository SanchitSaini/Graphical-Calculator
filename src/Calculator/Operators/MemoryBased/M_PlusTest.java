package Calculator.Operators.MemoryBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class M_PlusTest {

	@Test
	public void testEvaluatePass() {
		MSet obj1 = new MSet("20");
		obj1.evaluate();
		M_Plus obj2 = new M_Plus("50");
		assertEquals("70.0",obj2.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		M_Plus obj = new M_Plus("c");
		assertEquals(null,obj.evaluate());
	}

}
