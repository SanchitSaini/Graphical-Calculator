package Calculator.Operators;

import Calculator.CharacterInterpreter;
import Calculator.Operations.Arithmetic.Arithmetic;
import Calculator.Operations.MemoryBased.Memory;
import Calculator.Operations.Statistics.Statistics;
import Calculator.Operations.Trigonometric.Trigonometric;


public class Operator {

  protected FunctionFamily functionType;

  protected String operatorType;

    public Statistics  myStatistics;
    public Arithmetic  myArithmetic;
    public Memory  myMemory;
    public Trigonometric  myTrigonometric;
    public CharacterInterpreter myCharacterInterpreter;
    
  public Operator() {
  }

  public void evaluate() {
  }

}