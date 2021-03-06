package Calculator.Operators.Trigonometric;

import Calculator.AngleNotation;
import Calculator.ErrorModule;

import java.util.logging.Logger;



public class Sin extends Trigonometric {

	public Sin()
	{
		angleValue = null;
	}
	
	public Sin(String angleValueToUse) {
		super.angleValue = angleValueToUse;
	}

    public static int numberOfArgs()
    {
        return 1;
    }

  	public String evaluate() {
  		try {
  			Double angle = Double.parseDouble(super.angleValue);
			//Check if the angle type is Degree and return the result in degree form if it is
			if(super.getAngleType() == AngleNotation.DEGREES) {
				return String.valueOf(Math.sin(Math.toRadians(angle)));
			}
			//Else, check if the angle type is Radians and return the result in radian form if it is
			else if(super.getAngleType() == AngleNotation.RADIANS) {
				return String.valueOf(Math.sin(angle));
			}
			else {
				//For future extensions
				//Problematic if it comes here right now.
                //Display an error message
                ErrorModule.displayError("Error. Please try again.");
				//Log the entry
				Logger.getLogger("AngleType is invalid");
				//Return null if it comes here
				return null;
			}
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

}