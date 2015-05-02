package Calculator.Statistics;

import java.util.List;

import Calculator.Operators.Operator;

public abstract class Statistics {

  protected List<List<String>> dataPoints;

  public abstract String evaluate();
}