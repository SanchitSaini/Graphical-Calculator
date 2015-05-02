/*
 * Calculates the mean of data exported through a file in comma separated format.
 * If data is multi-dimensional, returns returns mean for every dimension considered individually.
 */

package Calculator.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Calculator.ErrorModule;

public class Mean extends Statistics {


	public Mean(){
		dataPoints = null;
	}

	public Mean(List<List<String>> data) {
		super.dataPoints = data;
	}

	@Override
	public String evaluate() {

		try
		{

			List<String> meanList = new ArrayList<String>();
			StringBuilder meanStr = new StringBuilder();
			boolean iter = false;
			//Display error if nothing is imported
			if(dataPoints == null)
			{
				ErrorModule.displayError("Please import a file or enter data points to work on.");
				return null;
			}
			
			//Compute mean
			for (List<String> row : dataPoints) {
				int length = row.size();
				float sum = 0;
				for(String col : row){
					sum += Float.parseFloat(col);
					//				System.out.print(col + " ");
				}

				float tempMean = sum/length;
				if(iter)
				{
					meanStr.append(", ");
				}
				meanStr.append(Float.toString(tempMean));
				meanList.add(String.valueOf(tempMean));
				iter = true;
				//			System.out.println(tempMean);
			}

			//		for(String col : meanList){
			//			System.out.print(col + " ");
			//		}

			String mean = meanStr.toString();
			System.out.println(mean);		
			return mean;
		}
		catch(Exception e)
		{
			ErrorModule.displayError("Error. Please try again.");
			Logger.getLogger(e.getMessage());
			return null;
		}

	}


}