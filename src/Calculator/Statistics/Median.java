/*
 * Calculates the median of data exported through a file in comma separated format.
 * If data is multi-dimensional, returns returns median for every dimension considered individually.
 */

package Calculator.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import Calculator.ErrorModule;



public class Median extends Statistics {

	public Median() {
		dataPoints = null;
	}

	public Median(List<List<String>> data) {
		super.dataPoints = data;
	}

	public String evaluate() {

		try{

			List<String> medianList = new ArrayList<String>();
			StringBuilder medianStr = new StringBuilder();
			boolean iter = false;
			
			//Display error if nothing is imported
			if(dataPoints == null)
			{
				ErrorModule.displayError("Please import a file or enter data points to work on.");
				return null;
			}
			
			//Calculate median
			for (List<String> row : dataPoints) {
				List<Float> medianFloat = new ArrayList<Float>();
				float tempMedian = 0;
				for(String col : row){
					medianFloat.add(Float.parseFloat(col));
				}

				Collections.sort(medianFloat);
				if(row.size()%2==0)
				{
					float median1 = medianFloat.get((medianFloat.size()/2)-1);
					float median2 = medianFloat.get( medianFloat.size()/2);
					tempMedian = (median1 + median2)/2;
					//				System.out.println(median1);
					//				System.out.println(median2);
					//				System.out.println(row.get(row.size()/2));
				}
				else
				{
					tempMedian = medianFloat.get(row.size()/2);
					//				System.out.println((row.size()/2));
					//				System.out.println(tempMedian);

				}

				if(iter)
				{
					medianStr.append(", ");
				}
				medianStr.append(Float.toString(tempMedian));
				medianList.add(String.valueOf(tempMedian));
				iter = true;

			}

			//		for(String col : medianList){
			//			System.out.print(col + " ");
			//		}

			String median = medianStr.toString();
			System.out.println(median);		
			return median;
		}
		catch(Exception e)
		{
			ErrorModule.displayError("Error. Please try again.");
			Logger.getLogger(e.getMessage());
			return null;
		}

	}



}