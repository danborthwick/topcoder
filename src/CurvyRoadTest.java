import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CurvyRoadTest {

    private final int[] length;
    private final int[] radius;
    private final double expected;

    public CurvyRoadTest(int[] length, int[] radius, double expected) {
        this.length = length;
        this.radius = radius;
        this.expected = expected;
    }


    static final int D_FOR_QUARTER_TURN = 100000;
    static final int L_FOR_QUARTER_TURN = (int) ((double) D_FOR_QUARTER_TURN * Math.PI / 2.0);

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{100}, new int[]{0}, 100},
                {new int[]{628}, new int[]{-1}, 0.3171858120571965},
                {new int[]{628,50,20,10}, new int[]{1,0,0,0}, 79.68684435034164},

                {new int[]{D_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN},
                        new int[]{0, D_FOR_QUARTER_TURN, 0, D_FOR_QUARTER_TURN, 0, D_FOR_QUARTER_TURN, 0, D_FOR_QUARTER_TURN}, 0},

                {new int[]{L_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN, L_FOR_QUARTER_TURN},
                        new int[]{D_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN, D_FOR_QUARTER_TURN}, 0},
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(CurvyRoad.distance(length, radius), closeTo(expected, 1E-9));
    }
}