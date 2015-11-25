import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BSTConstructionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 10,    12345678,  500000, 40},
                {  10,
                        87654321,
                        1000000, 31},
                { 10, 45454545,0, 55},
                { 1, 99988877,12345,1}
        });
    }

    private final int N;
    private final int seed;
    private final int limit;
    private final long expected;

    public BSTConstructionTest(int n, int seed, int limit, long expected)
    {
        N = n;
        this.seed = seed;
        this.limit = limit;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(BSTConstruction.sumHeights(N, seed, limit), is(expected));
    }
}