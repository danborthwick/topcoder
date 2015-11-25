import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AirwaysTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3,
                        -219,
                0,
                437.99999999999994},
                {        3,
        171,
        0,
        171.0},
                {        4,
        233,
        3111,
        3344.0000000000005},
                {       14,
                -3840,
                -1768,
        4243.534462721784}
        });
    }

    private final double expected;
    private final int n;
    private final int east;
    private final int north;

    public AirwaysTest(int n, int east, int north, double expected)
    {
        this.expected = expected;
        this.n = n;
        this.east = east;
        this.north = north;
    }

    @Test
    public void test() throws Exception {
        assertThat(Airways.distance(n, east, north), is(expected));
    }
}