import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BagsOfGoldTest {

    private final int[] bags;
    private final int expected;

    public BagsOfGoldTest(int[] bags, int expected) {
        this.bags = bags;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                0)
                { new int[]{7,2}, 5},
//        I will choose the 7, and then she gets the 2. So the result is 7 - 2 = 5.
//        1)
        { new int[]{2,7,3},-2},
//        It doesn't matter whether I choose the 2 or the 3. She will choose the 7 and I will get the remaining bag. (2+3) - 7 = -2
//        2)
            { new int[]{1000,1000,1000,1000,1000},1000},
//        Since I choose first I will get 3 bags and my partner will get only 2 bags. They all have the same value so (1000+1000+1000) - (1000+1000) = 1000.
//        3)
                { new int[]{823,912,345,100000,867,222,991,3,40000},-58111}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(BagsOfGold.netGain(bags), is(expected));
    }
}