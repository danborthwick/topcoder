import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class JumpingTest {

    private int x;
    private int y;
    private int[] jumpLengths;
    private final String expected;

    public JumpingTest(int x, int y, int[] jumpLengths, String expected) {
        this.x = x;
        this.y = y;
        this.jumpLengths = jumpLengths;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5,4, new int[]{2, 5},"Able"},
//        One possibility is to jump from (0, 0) to (2, 0), and then from (2, 0) to (5, 4).
//        1)
                {3,4, new int[]{4},"Not able"},
//        The distance from (0, 0) to (3, 4) is 5. You cannot get there using a single jump of length 4 - it is too short.
//        2)
                {3,4, new int[]{6},"Not able"},
//        The distance from (0, 0) to (3, 4) is 5. You cannot get there using a single jump of length 6 - it is too long.
//        3)
                {0,1, new int[]{100, 100},"Able"},
//        Here, one possible solution looks as follows: Let t = sqrt(100*100 - 0.5*0.5). Suwoko will make her first jump from (0, 0) to (t, 0.5), and her second jump from (t, 0.5) to (0, 1).
//        4)
                {300,400, new int[]{500},"Able"},
//        5)
                {11,12, new int[]{1,2,3,4,5,6,7,8,9,10},"Able"},
//        6)
                {11,12, new int[]{1,2,3,4,5,6,7,8,9,100},"Not able"}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(Jumping.ableToGet(x, y, jumpLengths), is(expected));
    }
}