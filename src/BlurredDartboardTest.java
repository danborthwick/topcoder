import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BlurredDartboardTest {

    private final int[] points;
    private final int p;
    private final int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                ////0)
                {new int[] { 0, 3, 4, 0, 0 },
        8,
        2},
        //Wojtek should hit part 2 twice. He will get 8 points.
        //1)
                {new int[] { 0, 0, 0, 0, 0 },
        15,
        5},
        //Wojtek should hit each part exactly once. He doesn't know the point values, but the total score will be always 15.
        //2)
                {new int[] { 4, 7, 8, 1, 3, 2, 6, 5 },
        2012,
        252},
        //3)
                {new int[] { 0, 0, 5, 0, 0, 0, 1, 3, 0, 0 },
        2012,
        307},
        //4)
                {new int[] { 0, 2, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 6, 0, 0, 0, 4, 0, 0, 0 },
        1000000000,
        84656087},        });
    }


    public BlurredDartboardTest(int[] points, int P, int expected)
    {
        this.points = points;
        p = P;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(BlurredDartboard.minThrows(points, p), is(expected));
    }
}