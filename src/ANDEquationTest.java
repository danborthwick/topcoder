import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ANDEquationTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, new int[] {1, 3, 5}},
                {7, new int[] {31, 7, 7}},
                {0, new int[] {1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0, 0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1}},
                {191411, new int[] {191411,256951,191411,191411,191411,256951,195507,191411,192435,191411, 191411,195511,191419,191411,256947,191415,191475,195579,191415,191411, 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947, 191411,191411,191411}},
                {-1, new int[] {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211}},
                {-1, new int[]{2, 3, 7, 19}}
        });
    }

    private final int expected;
    private final int[] inputs;

    public ANDEquationTest(int expected, int[] inputs)
    {
        this.expected = expected;
        this.inputs = inputs;
    }

    @Test
    public void test() throws Exception {
        assertThat(ANDEquation.restoreY(inputs), is(expected));
    }
}