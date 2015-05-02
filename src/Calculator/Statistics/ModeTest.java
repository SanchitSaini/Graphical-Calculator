package Calculator.Statistics;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.ImportExport;

public class ModeTest {

	@Test
	public void testEvaluatePass() {
		ImportExport data = new ImportExport();
		data.setDataSource("data.txt");
		data.importData();
		Mode obj= new Mode(data.getDataValues());
		assertEquals("3.0; 0.58; ",obj.evaluate());
	}
	
	@Test
	public void testEvaluateFail() {
		Mode obj= new Mode();
		assertEquals(null,obj.evaluate());
	}

}
