import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TheNumberGameDivOneTest {

    private final String input;
    private final String expected;

    public TheNumberGameDivOneTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Input", "Expected"},
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(Template.templateMethod(input), is(expected));
    }
}