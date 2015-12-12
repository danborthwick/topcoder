import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CostOfDancingTest {

    private final int K;
    private final int[] danceCost;
    private final int expected;

    public CostOfDancingTest(int k, int[] danceCost, int expected) {
        K = k;
        this.danceCost = danceCost;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, new int[]{1, 5, 3, 4}, 4},
//        Gustavo must pay for exactly two out of the four given courses. The cheapest possibility is to pay 1 for one course and then 3 for another course. The total cost is 1+3 = 4.
//        1)
                {3, new int[]{1, 5, 4}, 10},
//        Gustavo has no choice here. He has to pay for all three courses, which costs 1+5+4 = 10.
//        2)
                {1, new int[]{2, 2, 4, 5, 3},2},
//        Among all 5 possible courses he can take, the cheapest one is either the course #0 or course #1 (0-based).
//        3)
                {39, new int[]{973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932, 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801}, 20431}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(CostOfDancing.minimum(K, danceCost), is(expected));
    }
}