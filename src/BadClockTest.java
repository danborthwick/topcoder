import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BadClockTest {

    private String trueTime;
    private String skewTime;
    private int hourlyGain;
    private final double expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"07:07:07",
                "07:07:07",
                1776,
                0.0},
//        The clock is already showing the true time.,
                        {       "11:59:58",
        "12:03:28",
                -3,
        70.0},
//        This clock loses three seconds every hour, and will catch up with the true time in exactly 70 hours.,
                {"12:03:28",
        "11:59:58",
        3,
        70.0},
//        This clock gains three seconds per hour.,
                        { "03:03:02",
        "03:01:47",
        5,
        15.0},
                        { "03:03:02",
        "03:01:47",
                -5,
        8625.0},
                {"07:08:09",
        "09:08:07",
                -321,
        22.42367601246106},
        });
    }

    public BadClockTest(String trueTime, String skewTime, int hourlyGain, double expected)
    {
        this.trueTime = trueTime;
        this.skewTime = skewTime;
        this.hourlyGain = hourlyGain;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(BadClock.nextAgreement(trueTime, skewTime, hourlyGain), is(expected));
    }
}