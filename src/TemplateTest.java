import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TemplateTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Input", "Expected"},
        });
    }

    private final String expected;
    private final String input;

    public TemplateTest(String input, String expected)
    {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(Template.templateMethod(input), is(expected));
    }
}