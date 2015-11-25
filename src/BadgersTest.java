import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BadgersTest
{

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new int[] {1,2,3},
                        new int[] {2,2,1},
                7,
                2 },
                {        new int[]  {5,2,1,5},
        new int[] {0,2,4,1},
        19,
        3},
                { new int[] {1,1,1,1,1},
        new int[] {1000,1000,1000,1000,1000},
        10,
        1 },
                {new int[] {1,2,3,4,5,6,7,8,9,10},
        new int[] {10,9,8,7,6,5,4,3,2,1},
        100,
        5}
        });
    }

    private final int expected;
    private final int[] hunger;
    private final int[] greed;
    private final int totalFood;

    public BadgersTest(int[] hunger, int[] greed, int totalFood, int expected)
    {
        this.expected = expected;
        this.hunger = hunger;
        this.greed = greed;
        this.totalFood = totalFood;
    }

    @Test
    public void test() throws Exception {
        assertThat(Badgers.feedMost(hunger, greed, totalFood), is(expected));
    }
}