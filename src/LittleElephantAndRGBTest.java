import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LittleElephantAndRGBTest {

    private final String[] list;
    private final int minGreen;
    private final long expected;

    public LittleElephantAndRGBTest(String[] list, int minGreen, long expected) {
        this.list = list;
        this.minGreen = minGreen;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                0)
                { new String[]{"GRG"},2,        1},
//        The only valid quadruple is (0,0,2,2). For this quadruple we have S[a..b]="G" and S[c..d]="G", thus T = "GG".
//        1)
        { new String[]{"GG", "GG"}, 3, 9},
//        There are 3 valid quadruples such that T="GGGG" and 6 quadruples such that T="GGG".
//        2)
            { new String[]{"GRBGRBBRG"}, 2, 11 },
//        One of the valid quadruples is (0,0,3,5). This quadruple corresponds to the nice string T="GGRB".
//        3)
                { new String[]{"RRBRBBRRR", "R", "B"}, 1, 0},
//        4)
                    { new String[]{"GRGGGRBRGG", "GGGGGGGG", "BRGRBRB"}, 4, 12430 }
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(LittleElephantAndRGB.getNumber(list, minGreen), is(expected));
    }
}