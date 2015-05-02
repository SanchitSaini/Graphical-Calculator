package Calculator.Operators.MemoryBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class M_MinusTest {

	@Test
	public void testEvaluatePass() {
		MSet obj1 = new MSet("20");
		obj1.evaluate();
		M_Minus obj2 = new M_Minus("50");
		assertEquals("-30.0",obj2.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		M_Minus obj = new M_Minus("c");
		assertEquals(null,obj.evaluate());
	}


}
