package Calculator;

import Calculator.GUI.GUI;

public class CheckMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui = new GUI();
		gui.setVisible(true);
		ImportExport data = new ImportExport();
		data.setDataSource("C:\\Users\\Pawas\\Desktop\\data4.txt");
		data.importData();
	}

}
