package Calculator.Operators.Statistics;

import java.util.ArrayList;
import java.util.List;

public class Mean extends Statistics {


	public Mean(){
		dataPoints = null;
	}
	
	public Mean(List<List<String>> data) {
		super.dataPoints = data;
	}

	@Override
	public String evaluate() {
		
		
		List<String> meanList = new ArrayList<String>();
		StringBuilder meanStr = new StringBuilder();
		boolean iter = false;
//		if(dataPoints == null)
//		{
//			ErrorModule.displayError("Please import a file or enter data points to work on.");
//			return null;
//		}
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


}