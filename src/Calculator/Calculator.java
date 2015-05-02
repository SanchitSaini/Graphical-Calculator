
package Calculator;

import java.util.ArrayList;

import Calculator.EquationSolver.EquationSolver;
import Calculator.Plotter.Plotter;
import Calculator.SequenceSaver.SequenceSaver;
import Calculator.Statistics.Mean;
import Calculator.Statistics.Median;
import Calculator.Statistics.Mode;
import Calculator.Statistics.Statistics;


public class Calculator {

  private String input;
  private CharacterInterpreter charInterpreter;
  private String output;
  private Plotter plotter;
  private ImportExport data;
  private SequenceSaver operationSequence;
  private EquationSolver equationSolver;
  private Statistics statistics;


  public Calculator() {
	  input = null;
	  charInterpreter = null;
	  output = null;
	  plotter = null;
	  data = null;
	  operationSequence = null;
	  equationSolver = null;
	  statistics = null;
  }

//  private void setOutput(String output) {
//  }

  public String getOutput() {
	  return output;
  }

  private void setInput(String input) {
	  this.input = input;
  }

//  public ArrayList getInput() {
//	  return new ArrayList();
//  }

//  public void onEdit(String edit) {
//  }

  public void onClick(String abc) {
  }

//  public void displayResult(String abc) {
//  }
  
  public String compute(String expression)
  {
	  charInterpreter = new CharacterInterpreter();
	  try {
		  input = expression;
		  String output = charInterpreter.compute(input);
		return output;
	} catch (Exception e) {
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
	  statistics = new Mean(data.getDataValues());
	  String mean = statistics.evaluate();
	  return mean;
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