package Calculator.Operators.OtherBinary;

import java.util.logging.Logger;

import Calculator.ErrorModule;

public class LCM extends Binary {

	public LCM(String firstNumber, String SecondNumber) {
		super.firstOperand = firstNumber;
		super.secondOperand = SecondNumber;
	}

	public LCM() {
		firstOperand = null;
		secondOperand = null;
	}
	
	public String evaluate() {
		try {
			Double firstOp = Double.parseDouble(super.firstOperand);
			Double secondOp = Double.parseDouble(super.secondOperand);
			
			int firstNum = Integer.parseInt(String.valueOf(Math.ceil(firstOp)));
			int secondNum = Integer.parseInt(String.valueOf(Math.ceil(secondOp)));
			//Compute LCM
			long LCM = ComputeLCM(firstNum, secondNum);
			//Return the computation as a string 
			return String.valueOf(LCM);
		}
		catch(Exception e) {
			//Display an error message
            ErrorModule.displayError("Error. Please try again.");
            //Log the error
            Logger.getLogger(e.getMessage());
            //Return null
            return null;
		}
	}
	
	/**
	 * Function to compute LCM of two numbers
	 * @param firstNum first number
	 * @param secondNum second number
	 * @return LCM of the two numbers
	 */
	private long ComputeLCM(int firstNum, int secondNum) {
		long LCMCandidate = 0;
		if(firstNum > secondNum) {
			LCMCandidate = firstNum;
		}
		else {
			LCMCandidate = secondNum;
		}
		while(true) {
			if(LCMCandidate%firstNum == 0 && LCMCandidate%secondNum == 0) {
				return LCMCandidate;
			}
			++LCMCandidate;
		}
	}
}