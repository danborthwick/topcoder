import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LengthUnitCalculatorTest {

    private final int amount;
    private final String fromUnit;
    private final String toUnit;
    private final double expected;

    public LengthUnitCalculatorTest(int amount, String fromUnit, String toUnit, double expected) {
        this.amount = amount;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "mi", "ft", 5280.0},
                {1, "ft", "mi", 1.893939393939394E-4},
                {123, "ft", "yd", 41.0},
                {1000, "mi", "in", 6.336E7},
                {1, "in", "mi", 1.5782828282828283E-5},
                {47, "mi", "mi", 47.0}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(LengthUnitCalculator.calc(amount, fromUnit, toUnit), is(expected));
    }
}