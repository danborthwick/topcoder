import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RaftingTest {

    private final int raftSpeed;
    private final int runSpeed;
    private final int[] x;
    private final int[] y;
    private final int K;
    private final double expected;

    public RaftingTest(int raftSpeed, int runSpeed, int[] x, int[] y, int k, double expected) {
        this.raftSpeed = raftSpeed;
        this.runSpeed = runSpeed;
        this.x = x;
        this.y = y;
        K = k;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
              { //0)
        1,
        50,
        new int[] {0},
        new int[] {1},
        1,
        0.04000800240080029 },
//        The man can run very fast, so he should leave the raft near point (0, 0) and return near this point too.
        { //1)
        1,
        50,
        new int[] {0, 0},
        new int[] {1, 1},
        2,
        0.04000800240080029},
//        The sites can coincide.
        { //2)
        1,
        2,
        new int[] {0},
        new int[] {1},
        1,
        1.1547005383792515},
//        The man should leave the raft near the point (-sqrt(3) / 3, 0) and come back near the point (+sqrt(3) / 3, 0).
      { //3)
        1,
        50,
        new int[] {10, -10},
        new int[] {1, 1},
        2,
        0.08001600480160058},
//        The man should leave the raft twice to visit two sites separately.
      { //4)
        4,
        21,
        new int[] {6, -1, 4, 6, 7, 1},
        new int[] {1, 5, 3, 2, 5, 2},
        6,
        0.9517633779247896}        
      });
    }

    @Test
    public void test() throws Exception {
        assertThat(Rafting.minRunningTime(raftSpeed, runSpeed, x, y, K), closeTo(expected, 1E-9));
    }
}