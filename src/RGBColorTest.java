import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RGBColorTest {

    private final int[] input;
    private final int[] expected;

    public RGBColorTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                0)
                { new int[]{255,0,0},
        new int[]{ 0, 255, 255 }},
//        The complement of red is cyan.
//        1)
                {new int[]{115,115,143},
        new int[]{ 243, 243, 15 }},
//        The complement of this bluish-grey would normally have been {140,140,112}. But since each component of the complement would have been within 32 of the corresponding component of rgb we return the alternate complement instead.
//        2)
                {new int[]{115,115,144},
        new int[]{ 140, 140, 111 }},
//        Also a bluish-grey, but in this case the blue component of the complement differs by 33 from the blue component of rgb, just enough so that we don't need to return the alternate complement.
//        3)
                {new int[]{153,12,55},
        new int[]{ 102, 243, 200 }}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(RGBColor.getComplement(input), is(expected));
    }
}