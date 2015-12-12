import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BoxesDiv2Test {

    private final int[] input;
    private final int expected;

    public BoxesDiv2Test(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                0)
                {new int[]{8, 8}, 16},
//        First, you pack each type of candies into a box with volume 8. Then, you pack the two boxes into a single box with volume 16.
//        1)
                {new int[]{5, 6}, 16},
//        Even though you have fewer candies than in Example 0, you still have to use boxes with volume 8 (or more) to store them.
//        2)
                {new int[]{1, 7}, 16},
//        Now you could pack the 1 candy into a smaller box, but it will not help: you still have to use a box with volume 16 to store the two boxes with candies.
//        3)
                {new int[]{1, 1, 13, 1, 1}, 32},
//        4)
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32}, 1024}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(BoxesDiv2.findSize(input), is(expected));
    }
}