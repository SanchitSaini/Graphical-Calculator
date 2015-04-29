package Calculator.Operators.Statistics;

import java.util.ArrayList;
import java.util.List;

public class Mean extends Statistics {


	public Mean(List<List<String>> data) {
		super.dataPoints = data;
	}

	@Override

	public String evaluate() {
		List<String> meanList = new ArrayList<String>();

		for (List<String> row : dataPoints) {
			int length = row.size();
			float sum = 0;
			for(String col : row){
				sum += Float.parseFloat(col);
				//				System.out.print(col + " ");
			}

			float mean = sum/length;
			meanList.add(String.valueOf(mean));
			//			System.out.println(mean);
		}

		for(String col : meanList){
			System.out.print(col + " ");
		}
		return new String();

	}


}