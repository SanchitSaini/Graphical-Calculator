package Calculator;

import Calculator.GUI.GUI;
import Calculator.Operators.Operator;
import Calculator.Operators.Arithmetic.Add;
import Calculator.Operators.Statistics.Mean;
import Calculator.Operators.Statistics.Median;
import Calculator.Operators.Statistics.Mode;
import Calculator.Operators.Statistics.Statistics;

/***
 *  Class to check new functionalities
 */
public class CheckMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GUI gui = new GUI();
//		gui.setVisible(true);
//		
//		String[] input = new String[2];
//		input[0] = "12.4";
//		input[1] = "12.3";
//		
//		String[] abc = new String[4];
//	
//		String[] symbol = new String[4];
//		symbol[0] = "+";
//		symbol[1] = "-";
//		symbol[2] = "*";
//		symbol[3] = "/";
//		//symbol[4] = "M+";
//		
//		Operator a = new Add(input[0],input[1]);
//		for(int i=0; i<1;i++) {
//			System.out.println(input[0] +" " +symbol[i] + " "+ input[1] +" = " + a.evaluate());
//		}
//				
		ImportExport data = new ImportExport();
		data.setDataSource("C:\\Users\\Pawas\\Desktop\\data4.txt");
		data.importData();
//		Statistics meanObj = new Mean(data.getDataValues());
//		meanObj.evaluate();
//		Statistics medObj = new Median(data.getDataValues());
//		medObj.evaluate();
		Statistics modeObj = new Mode(data.getDataValues());
		modeObj.evaluate();
		
	}

}
