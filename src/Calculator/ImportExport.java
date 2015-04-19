package Calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;


public class ImportExport {

	private Alignment alignType;
	private String dataSource;
	private List<List<String>> dataValues;

	public ImportExport() {
		dataSource = null;
		dataValues = null;
		alignType = Alignment.ROWWISE;
	}

	public void importData() {

		BufferedReader reader = null;
		String line = "";
		String delimiter = ",";
		List<List<String>> data = new ArrayList<List<String>>();

		//Read the files
		//Valid input is a csv file
		try{
			reader = new BufferedReader(new FileReader(dataSource));
			while ((line = reader.readLine()) != null) {
				String[] text = line.split(delimiter);
				//System.out.println(Arrays.toString(text));
				List<String> temp = new ArrayList<String>();
				for (int i = 0; i<text.length; i++)
				{
					temp.add(text[i]);
				}
				data.add(temp);
			}

			List<List<String>> rearrangedData = new ArrayList<List<String>>();

			if(alignType == Alignment.COLUMNWISE)
			{
				int width = data.get(0).size();
				for (int i = 0; i < width; i++) {
					List<String> col = new ArrayList<String>();
					for (List<String> row : data) {
						col.add(row.get(i));
					}
					rearrangedData.add(col);
				}
				dataValues = rearrangedData;
			}
			else
				dataValues = data;
			
			for(List<String> row : dataValues){
				for(String col : row){
					System.out.print(col + " ");
				}
				System.out.print("\n");
			}


		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void exportData() {
	}

	public String getDataSource() {
		return dataSource;
	}

	public Alignment getAlignType() {
		return alignType;
	}

	public List<List<String>> getDataValues() {
		return dataValues;
	}

	public void setDataSource(String source) {
		dataSource = source;
	}

	public void setAlignType(Alignment alignType) {
		this.alignType = alignType;
	}

	public void setDataValues(List<List<String>> values) {
		dataValues = values;
	}

}