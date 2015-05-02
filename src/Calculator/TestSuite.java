package Calculator;

/**
 * Created by Pranav on 03-05-2015.
 */

import Calculator.Operators.Trigonometric.Trigonometric;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Calculator.Operators.Arithmetic.*;
import Calculator.Operators.MemoryBased.*;
import Calculator.Operators.OtherUnary.*;
import Calculator.Operators.OtherBinary.*;
import Calculator.Operators.Trigonometric.*;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CharacterInterpreterTest.class,
        AddTest.class,
        DivideTest.class,
        MultiplyTest.class,
        SubtractTest.class,
        M_MinusTest.class,
        M_PlusTest.class,
        MClearTest.class,
        MSetTest.class,
        MRecall.class,
        AExpBTest.class,
        CombinationTest.class,
        PercentageTest.class,
        PermutationTest.class,
        HCFTest.class,
        LCMTest.class,
        AbsoluteTest.class,
        CeilingTest.class,
        ExpTest.class,
        FactorialTest.class,
        FloorTest.class,
        LogTest.class,
        Log10Test.class,
        SquareRootTest.class,
        SquareTest.class,
        TenExpXTest.class,
        SinTest.class,
        SinInverseTest.class,
        CosTest.class,
        CosInverseTest.class,
        TanTest.class,
        TanInverseTest.class,
        CotTest.class,
        CotInverseTest.class,
        SecTest.class,
        SecInverseTest.class,
        CosecTest.class,
        CosecInverseTest.class
})
public class TestSuite {
}
