package Calculator.Operators;

import Calculator.Operators.MemoryBased.MSet;
import Calculator.Operators.MemoryBased.M_Minus;
import Calculator.Operators.Others.Absolute;
import Calculator.Operators.Trigonometric.Sin;

public class OperatorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String[] input = new String[2];
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
		//symbol[4] = "M+";
		
		//Operator a = new (input[0],input[1]);
//		for(int i=0; i<1;i++) {
//			System.out.println(input[0] +" " +symbol[i] + " "+ input[1] +" = " + a.evaluate());
//		}
		
		Operator a = new MSet("-12");
		String res = a.evaluate();
		System.out.println(res);
		a = new Absolute("10");
		res = a.evaluate();
		System.out.println(res);
		a = new Sin("12");
		
		
	}

}
