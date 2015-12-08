import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DiamondHuntTest {

    private final String input;
    private final int expected;

    public DiamondHuntTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"><<><>>><", 3},
                {">>>><<", 0},
                {"<<<<<<<<<>>>>>>>>>",9},
                {"><<><><<>>>><<>><<><<>><<<>>>>>><<<", 14},
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(DiamondHunt.countDiamonds(input), is(expected));
    }
}