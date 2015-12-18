import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TheNumberGameDivTwoTest {

    private final int input;
    private final String expected;

    public TheNumberGameDivTwoTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {6, "John"},
                {2, "Brus"},
                {747, "Brus"},
                {128, "Brus"}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(TheNumberGameDivTwo.find(input), is(expected));
    }
}