/*
 * Calculates the mode of data exported through a file in comma separated format.
 * If data is multi-dimensional, returns returns mode for every dimension considered individually.
 */

package Calculator.Operators.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Mode extends Statistics {


	public Mode() {
		dataPoints = null;
	}

	public Mode(List<List<String>> data) {
		super.dataPoints = data;
	}

	public String evaluate() {

		try{

			StringBuilder modeStr = new StringBuilder();
			
			//Display error if nothing is imported
			if(dataPoints == null)
			{
				ErrorModule.displayError("Please import a file or enter data points to work on.");
				return null;
			}

			//Calculate mode
			for (List<String> row : dataPoints) {
				List<Float> modeFloat = new ArrayList<Float>();
				StringBuilder tempMode = new StringBuilder();
				int freq = 0;
				for(String col : row){
					modeFloat.add(Float.parseFloat(col));
				}

				Set<Float> unique = new HashSet<Float>(modeFloat);

				for (Float key : unique) {
					if(Collections.frequency(modeFloat, key) > freq)
					{
						freq = Collections.frequency(modeFloat, key);
					}
					//			    System.out.println(key + ": " + Collections.frequency(modeFloat, key));
				}
				boolean flag = false;
				for (Float key : unique)
				{
					if(Collections.frequency(modeFloat, key) == freq)
					{
						if(flag)
						{
							tempMode.append(", ");
						}
						tempMode.append(Float.toString(key));
						flag = true;
					}
				}

				modeStr.append(tempMode);
				modeStr.append("; ");

			}

			String mode = modeStr.toString();
			System.out.println(mode);		
			return mode;
		}
		catch(Exception e)
		{
			ErrorModule.displayError("Error. Please try again.");
			Logger.getLogger(e.getMessage());
			return null;
		}
	}



}