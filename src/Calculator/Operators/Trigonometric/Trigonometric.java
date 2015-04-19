package Calculator.Operators.Trigonometric;

import Calculator.Operators.Operator;

public abstract class Trigonometric extends Operator {

  protected AngleNotation angleType;
  protected String angleValue;

  public abstract String evaluate();
}