package Calculator.Operators.Others;

import Calculator.ErrorModule;

import java.util.logging.Logger;

public class HCF extends More_Function_Families{

	public HCF() {
		
	}

	public String evaluate() {
		try {
			Double firstOp = Double.parseDouble(super.firstOperand);
			Double secondOp = Double.parseDouble(super.secondOperand);
			
			int firstNum = Integer.parseInt(String.valueOf(Math.ceil(firstOp)));
			int secondNum = Integer.parseInt(String.valueOf(Math.ceil(secondOp)));
			//Compute HCF
			int HCF = ComputeHCF(firstNum, secondNum);
			//Return the computation as a string 
			return String.valueOf(HCF);
		}
        catch(Exception e)
        {
            //Display an error message
            ErrorModule.displayError("Error. Please try again.");
            //Log the error
            Logger.getLogger(e.getMessage());
            //Return null
            return null;
        }
	}
	
	/**
	 * Function to compute HCF of two numbers
	 * @param firstNum first number
	 * @param secondNum second number
	 * @return HCF of the two numbers
	 */
	private int ComputeHCF(int firstNum, int secondNum) {
		int greaterNum = 0;
		int smallerNum = 0;
		int remainder=0;
		
		//Check which number is greater
		if(firstNum > secondNum) {
			greaterNum = firstNum;
			smallerNum = secondNum;
		}
		else {
			greaterNum = secondNum;
			smallerNum = firstNum;

		}
		remainder = smallerNum;
		while(greaterNum % smallerNum != 0) {
			remainder = greaterNum % smallerNum;
			greaterNum = smallerNum;
			smallerNum = remainder;
		}
		return remainder;
	}
}
