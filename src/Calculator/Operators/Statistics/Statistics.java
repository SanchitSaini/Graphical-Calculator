package Calculator.Operators.Statistics;

import Calculator.Operators.Operator;

public abstract class Statistics extends Operator {

  protected String[] dataPoints;

  public abstract String evaluate();
}