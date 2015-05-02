
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

		}
		try {
			input = expression;
			String output = charInterpreter.compute(input);
			return output;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
	}


	public void readFromFile(String fileName){
		data = new ImportExport();
		data.setDataSource(fileName);
		data.importData();

	}

	public String computeMean()
	{
		try{
			statistics = new Mean(data.getDataValues());
			String mean = statistics.evaluate();
			return mean;
		}
		catch(NullPointerException e)
		{
			ErrorModule.displayError("Please import a file or enter data points to work on.");
			Logger.getLogger(e.getMessage());
			return null;
		}
	}

	public String computeMedian()
	{
		statistics = new Median(data.getDataValues());
		String median = statistics.evaluate();
		return median;
	}

	public String computeMode()
	{
		statistics = new Mode(data.getDataValues());
		String mode = statistics.evaluate();
		return mode;
	}  

}