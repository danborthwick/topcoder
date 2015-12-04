import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AutoAdjustTest {

    private final String[] input;
    private final String[] expected;

    public AutoAdjustTest(String[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[]{"------------", "--TTT--CCC--", "---T---C----", "---T---CCC--", "------------"},
                        new String[]{"            ", "  ___  CCC  ", "   _   C    ", "   _   CCC  ", "            " }
                },
                {
                        new String[]{"         ", " ___ CCC ", " _ C ", " _ CCC ", "         "},
                        new String[]{"         ", " ___ CCC ", " _ C ", " _ CCC ", "         "}
                },
                {
                        new String[]{"AB"},
                        new String[]{" _" }
                },

        });
    }

    @Test
    public void test() throws Exception {
        assertThat(AutoAdjust.adjust(input), is(expected));
    }
}