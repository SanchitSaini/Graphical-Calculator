package Calculator;

import java.util.ArrayList;

import Calculator.EquationSolver.EquationSolver;
import Calculator.Operators.Statistics.Mean;
import Calculator.Operators.Statistics.Median;
import Calculator.Operators.Statistics.Mode;
import Calculator.Operators.Statistics.Statistics;
import Calculator.Plotter.Plotter;
import Calculator.SequenceSaver.SequenceSaver;


public class Calculator {

  private ArrayList<String> input;
  private CharacterInterpreter charInterpreter;
  private ArrayList<String> output;
  private Plotter plotter;
  private ImportExport data;
  private SequenceSaver operationSequence;
  private EquationSolver equationSolver;


  public Calculator() {
  }

  private void setOutput(String output) {
  }

  public String getOutput() {
	  return new String();
  }

  private void setInput(ArrayList input) {
  }

  public ArrayList getInput() {
	  return new ArrayList();
  }

  public void onEdit(String edit) {
  }

  public void onClick(String abc) {
  }

  public void displayResult(String abc) {
  }
  
  public void compute(String exp)
  {
	  //charInterpreter.compute(exp);
  }

  
  public void readFromFile(String fileName){
	  data = new ImportExport();
	  data.setDataSource(fileName);
	  data.importData();
		
  }
  
  public String computeMean()
  {
	  Statistics meanObj = new Mean(data.getDataValues());
	  String mean = meanObj.evaluate();
	  return mean;
  }
  
  public String computeMedian()
  {
	  Statistics medianObj = new Median(data.getDataValues());
	  String median = medianObj.evaluate();
	  return median;
  }
  
  public String computeMode()
  {
	  Statistics modeObj = new Mode(data.getDataValues());
	  String mode = modeObj.evaluate();
	  return mode;
  }
  
  
}