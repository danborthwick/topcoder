import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NoEightsTest {

    private final int low;
    private final int high;
    private final int expected;

    public NoEightsTest(int low, int high, int expected) {
        this.low = low;
        this.high = high;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 10, 0},
                {88, 88, 2},
                {800, 899, 1},
                {8808, 8880, 2}
        });
    }


    @Test
    public void test() throws Exception {
        assertThat(NoEights.smallestAmount(low, high), is(expected));
    }
}