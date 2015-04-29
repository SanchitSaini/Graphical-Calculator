package Calculator.Operators.Statistics;

import java.util.List;

import Calculator.Operators.Operator;

public abstract class Statistics extends Operator {

  protected List<List<String>> dataPoints;

  public abstract String evaluate();
}