import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ConstructionFromMatchesTest {

    private final int[] cost;
    private final int[] top;
    private final int[] bottom;
    private final int expected;

    public ConstructionFromMatchesTest(int[] cost, int[] top, int[] bottom, int expected) {
        this.cost = cost;
        this.top = top;
        this.bottom = bottom;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //0)
                {new int[] {1, 2},
        new int[] {7},
        new int[] {5},
        10 },
//        The cheapest solution contains 3 matches of thickness 2 and 4 matches of thickness 1. It may look as follows (each digit d denotes a single match of thickness d):
//
//        1
//        2 2
//        2
//        1 1
//        1
//        //1)
                {new int[] {1},
        new int[] {5},
        new int[] {5},
        -1 },
//        Obviously we can't get a square with thickness 5 using only matches of thickness 1.
        //2)
                {new int[] {1, 5, 9},
        new int[] {7, 10},
        new int[] {8, 9},
        56 },
//        One of the optimal solutions looks as follows (each digit d denotes a single match of thickness d):
//
//        1 3
//        1 3 1
//        2 3
//        1 3 1
//        2 2
        //3)
                {new int[] {1, 3, 4, 7, 9},
        new int[] {13, 14, 13, 11, 9, 7, 11, 8, 8, 10},
        new int[] {18, 14, 17, 10, 8, 4, 8, 13, 14, 13},
        194 },
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(ConstructionFromMatches.minimumCost(cost, top, bottom), is(expected));
    }
}