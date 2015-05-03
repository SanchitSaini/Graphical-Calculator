
package Calculator;

import java.util.logging.Logger;

import Calculator.Operators.Trigonometric.Trigonometric;
import Calculator.Statistics.Mean;
import Calculator.Statistics.Median;
import Calculator.Statistics.Mode;
import Calculator.Statistics.Statistics;

/***
 * Basic class of the calculator. Contains all the required components of a calculator
 */
public class Calculator {

	private String input;
	private CharacterInterpreter charInterpreter;
	private String output;
	private ImportExport data;
	private Statistics statistics;

	/**
	 * Constructor that sets all the private members to null
	 */
	public Calculator() {
		input = null;
		charInterpreter = null;
		output = null;
		data = null;
		statistics = null;
	}

	/**
	 * Function that gets the output as a string
	 * @return Output as a string
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * This function tries to compute/evaluate the solution of the calculation to be performed
	 * @param expression The expression to be evaluated
	 * @param angleType Type of angles being entered. May be Radians or Degrees
	 * @return the computed output
	 */
	public String compute(String expression,String angleType)
	{
		//Create an object of the object that interprets the characters
		charInterpreter = new CharacterInterpreter();
		//Check if the user is inputting the angles as Radians
		if(angleType.equals("Radian")) {
			//If yes, store the information internally for computational purposes
			Trigonometric.setAngleType(AngleNotation.RADIANS);
		}
		//Else, check if the user is inputting the angles as Degrees
		else if(angleType.equals("Degree")) {
			//If yes, store this information internally for computational purposes
			Trigonometric.setAngleType(AngleNotation.DEGREES);
		}
		//Else, raise an error, since angle should either be in radians or degrees
		else {
			//Display the error in the Error Module
			ErrorModule.displayError("Angle type not valid.");
			//Log the error
			Logger.getLogger("Angle type not valid.");
			//Return null to convey that an exception occured
			return null;
		}
		try {
			input = expression;
			String output = charInterpreter.compute(input);
			return output;
		} 
		catch (Exception e) {
			//Display the error in the Error Module
			ErrorModule.displayError("Please import a file or enter data points to work on.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}  
	}


	/**
	 * Function that reads data points from a file
	 * @param fileName
	 */
	public void readFromFile(String fileName){
		try {
			
		}
		catch (Exception e) {
			//Display the error in the Error Module
			ErrorModule.displayError("Error reading from file.");
			//Log the error
			Logger.getLogger(e.getMessage());
		}
		//Create an object that allows file based import and export
		data = new ImportExport();
		//Open the file to be read
		data.setDataSource(fileName);
		//Import the data from file and store it in the data member internally
		data.importData();

	}

	/**
	 * 
	 * @return
	 */
	public String computeMean()
	{
		try{
			statistics = new Mean(data.getDataValues());
			String mean = statistics.evaluate();
			return mean;
		}
		catch(NullPointerException e)
		{
			//Display the error in the Error Module
			ErrorModule.displayError("Please import a file or enter data points to work on.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
		catch(Exception e) {
			//Display the error in the Error Module
			ErrorModule.displayError("Error! Please try again.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
	}

	public String computeMedian()
	{
		try {
			statistics = new Median(data.getDataValues());
			String median = statistics.evaluate();
			return median;
		}
		catch(NullPointerException e)
		{
			//Display the error in the Error Module
			ErrorModule.displayError("Please import a file or enter data points to work on.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
		catch(Exception e) {
			//Display the error in the Error Module
			ErrorModule.displayError("Error! Please try again.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
	}

	public String computeMode()
	{
		try {
			statistics = new Mode(data.getDataValues());
			String mode = statistics.evaluate();
			return mode;
		}
		catch(NullPointerException e)
		{
			//Display the error in the Error Module
			ErrorModule.displayError("Please import a file or enter data points to work on.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
		catch(Exception e) {
			//Display the error in the Error Module
			ErrorModule.displayError("Error! Please try again.");
			//Log the error
			Logger.getLogger(e.getMessage());
			//Return null to convey that an exception occured
			return null;
		}
	}  

}