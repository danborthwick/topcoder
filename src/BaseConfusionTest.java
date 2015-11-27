import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BaseConfusionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {14, 18, 3, 129},
                {1,
        10,
        16,
        55},
                {        100,
        100,
        10,
        121},
                {209881,
        210565,
        3,
        3141592653L}
        });
    }

    private final int M, N, B;
    private final long expected;

    public BaseConfusionTest(int m, int n, int b, long expected)
    {
        M = m;
        N = n;
        B = b;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(BaseConfusion.sum(M, N, B), is(expected));
    }
}