import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CityLinkTest {

    private int[] x;
    private int[] y;
    private int expected;

    public CityLinkTest(int[] x, int[] y, int expected) {
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new int[]{0,5},
                        new int[]{0,5}, 5},
                { new int[]{0,0},
                        new int[]{30,-59}, 45},
                { new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26, 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49},
                        new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26, 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49},
                        1 },
                { new int[]{100000}, new int[]{-1000000},0},
                { new int[] {1593,-88517,14301,3200,6,-15099,3200,5881,-2593,11,57361,-92990},
                    new int[]{99531,-17742,-36499,1582,46,34001,-19234,1883,36001,0,233,485},
            73418}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(CityLink.timeTaken(x, y), is(expected));
    }
}