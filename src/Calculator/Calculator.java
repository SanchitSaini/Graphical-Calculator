package Calculator;

import java.util.ArrayList;

import Calculator.EquationSolver.EquationSolver;
import Calculator.Plotter.Plotter;
import Calculator.SequenceSaver.SequenceSaver;


public class Calculator {

  private ArrayList<String> input;
  private CharacterInterpreter charInterpreter;
  private ArrayList<String> output;
  private Plotter plotter;
  private ImportExport importExport;
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

}