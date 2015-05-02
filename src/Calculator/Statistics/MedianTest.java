package Calculator.Statistics;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.ImportExport;

public class MedianTest {

	@Test
	public void testEvaluatePass() {
		ImportExport data = new ImportExport();
		data.setDataSource("data.txt");
		data.importData();
		Median obj= new Median(data.getDataValues());
		assertEquals("3.0, 0.42",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Median obj= new Median();
		assertEquals(null,obj.evaluate());
	}

}
