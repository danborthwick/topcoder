import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NextOrPrevTest {

    private int nextCost;
    private int prevCost;
    private String start;
    private String goal;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5,
                        8,
                        "ae",
                        "bc",
                        21},
                {5,
                        8,
                        "ae",
                        "cb", -1},
                {1,
                        1,
                        "srm",
                        "srm", 0},
                {10,
                        1,
                        "acb",
                        "bdc", 30},
                {10,
                        1,
                        "zyxw",
                        "vuts",
                        16},
                {563,
                        440,
                        "ptrbgcnlaizo",
                        "rtscedkiahul",
                        10295},
                {126,
                        311,
                        "yovlkwpjgsna",
                        "zpwnkytjisob",
                        -1},
        });
    }

    private final int expected;

    public NextOrPrevTest(int nextCost, int prevCost, String start, String goal, int expected)
    {
        this.nextCost = nextCost;
        this.prevCost = prevCost;
        this.start = start;
        this.goal = goal;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(NextOrPrev.getMinimum(nextCost, prevCost, start, goal), is(expected));
    }
}