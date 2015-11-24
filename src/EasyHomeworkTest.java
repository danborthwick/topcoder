import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class EasyHomeworkTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 7, 2}, "POSITIVE"},
                {new int[]{-5, 7, 2}, "NEGATIVE"},
                {new int[]{5, 7, 2, 0}, "ZERO"},
                {new int[]{3, -14, 159, -26}, "POSITIVE"},
                {new int[]{-1000000000}, "NEGATIVE"},
                {new int[]{123, -456, 789, -101112, 131415, 161718, 192021, 222324, 252627, 282930, 313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354, 555657}, "POSITIVE"}
        });
    }

    private final String expected;
    private final int[] input;

    public EasyHomeworkTest(int[] input, String expected)
    {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(EasyHomework.determineSign(input), is(expected));
    }
}