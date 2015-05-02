package Calculator.Statistics;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.ImportExport;

public class MeanTest {

	@Test
	public void testEvaluatePass() {
		ImportExport data = new ImportExport();
		data.setDataSource("data.txt");
		data.importData();
		Mean obj= new Mean(data.getDataValues());
		assertEquals("3.6666667, 0.39977777",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Mean obj= new Mean();
		assertEquals(null,obj.evaluate());
	}

}
