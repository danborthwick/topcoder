import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SubgridsCounterTest {

    private final int[] x, y;
    private final int expected;

    public SubgridsCounterTest(int[] x, int[] y, int expected) {
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3},
                        new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3},
                        4},
                {new int[]{7, 0, 14, 0, 7, 14, 14, 0, 7},
                        new int[]{14, 0, 14, 14, 7, 7, 0, 7, 0}, 1},
                {new int[]{6, 6, 3, 0, 0, 3, 0, 3, 6, 1, 2},
                        new int[]{6, 3, 0, 0, 6, 3, 3, 6, 0, 1, 2},
                        1},
                {new int[]{6, 0, 4, 0, 20, 0, 0, 4, 12, 6, 6, 12, 12, 6, 0, 12, 4, 6, 4, 4, 20, 20, 20, 6, 6, 4, 20, 4, 20, 12, 12, 0, 12, 0, 20},
                        new int[]{4, 10, 10, 9, 10, 25, 0, 16, 25, 0, 18, 0, 4, 10, 4, 16, 4, 16, 25, 18, 9, 4, 18, 9, 25, 0, 0, 9, 25, 9, 18, 16, 10, 18, 16},
                        1}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(SubgridsCounter.howMany(x, y), is(expected));
    }
}