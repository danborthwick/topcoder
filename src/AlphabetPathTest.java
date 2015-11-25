import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AlphabetPathTest
{

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new String[] {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"},
                "YES"},
        { new String[] {"ADEHI..Z", "BCFGJK.Y", ".PONML.X", ".QRSTUVW"},
        "YES"},
        { new String[] {"ACBDEFGHIJKLMNOPQRSTUVWXYZ"},
        "NO" },
        { new String[] {"ABC.......", "...DEFGHIJ", "TSRQPONMLK", "UVWXYZ...."},
        "NO" },
        { new String[] {"..............", "..............", "..............", "...DEFGHIJK...", "...C......L...", "...B......M...", "...A......N...", "..........O...", "..ZY..TSRQP...", "...XWVU.......", ".............."},
        "YES" }
        });
    }

    private final String expected;
    private final String[] input;

    public AlphabetPathTest(String input[], String expected)
    {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(AlphabetPath.doesItExist(input), is(expected));
    }
}