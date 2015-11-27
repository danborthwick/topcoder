import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AbacusTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[] {"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
                5,
                new String[] {"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "o---oooooooo", "ooooo---oooo" }},
                {new String[]         {"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
        21,
                new String[] {"oo---ooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---" }},
                {new String[]         {"ooooooooo---", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
        100000,
                new String[]  {"oooooooo---o", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo", "---ooooooooo" }},
                {new String[]         {"o---oooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo" },
        1,
                new String[] {"---ooooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---" }}
        });
    }

    private final String[] input;
    private final int val;
    private final String[] expected;

    public AbacusTest(String[] input, int val, String[] expected)
    {
        this.val = val;
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(Abacus.add(input, val), is(expected));
    }
}