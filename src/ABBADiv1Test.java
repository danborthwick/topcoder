import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ABBADiv1Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"A", "BABA", "Possible"},
                {"BAAAAABAA", "BAABAAAAAB", "Possible"},
                {"A", "ABBA", "Impossible"},
                {"AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB", "Possible" },
                {"AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB", "Impossible" }
        });
    }

    private final String expected;
    private final String from;
    private final String to;

    public ABBADiv1Test(String from, String to, String expected)
    {
        this.expected = expected;
        this.from = from;
        this.to = to;
    }

    @Test
    public void test() throws Exception {
        assertThat(ABBADiv1.canObtain(from, to), is(expected));
    }
}