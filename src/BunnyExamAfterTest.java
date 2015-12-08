import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BunnyExamAfterTest {

    private final String black, grey, white;
    private final int expected;

    public BunnyExamAfterTest(String black, String grey, String white, int expected) {
        this.black = black;
        this.grey = grey;
        this.white = white;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //0)
                {"ABC","ABC","ABC",0},
//        We know that all of Black's answers were incorrect, and since Gray and White had the exact same answers as Black, they too got 0 points.
//        1)
                {"A","B","B",2},
//        The correct answer for the only problem is one of 'B' - 'Z'. If it is 'B', Gray and White will each get 1 point and the total is 2 points. If it is one of 'C' - 'Z', Gray and White will each get 0 points and the total is 0 points.
//        2)
                {"ABC","PQR","XYZ",3},
//        Gray might get 3 points and White might get 3 points, but the total will not exceed 3 points.
//        3)
                {"AAAAA","AABBB","BBBAA",6},
//        4)
                {"TOPCODER","TOPBUNNY","THEHONEY",9}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(BunnyExamAfter.getMaximum(black, grey, white), is(expected));
    }
}