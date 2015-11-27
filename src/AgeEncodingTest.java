import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AgeEncodingTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10,
                "00010",
                10.0},
//        This is the first example from the statement: simply a decimal notation of the given age. Note that notation can have leading zeroes.,
//        1),
                {21,
        "10101",
        2.0},
//        This is the second example from the statement: "10101" is a binary notation of the given age.,
//        2),
                { 6,
        "10100",
        1.414213562373095},
//        This is the third example from the statement.,
//        3),
                { 21,
        "10111111110111101111111100111111110111111111111100",
        0.9685012944510603},
//        4),
                {16,
        "1",
        -1.0},
//        In any base, "1" represents the age of 1, so it's impossible to get the age of 16.,
//        5),
                {1,
        "1",
        -2.0},
//        In any base, "1" represents the age of 1.,
//        6),
                {1,
        "001000",
        1.0},
        });
    }

    private final int age;
    private final String candlesLine;
    private final double expected;

    public AgeEncodingTest(int age, String candlesLine, double expected)
    {
        this.age = age;
        this.candlesLine = candlesLine;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(AgeEncoding.getRadix(age, candlesLine), closeTo(expected, 1E-9));
    }
}