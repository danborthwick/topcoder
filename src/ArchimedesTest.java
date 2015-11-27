import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ArchimedesTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 2.598076211353316},
                {        8,
        3.0614674589207183 },
                { 17280,
        3.1415926362832276 }

        });
    }

    private final int numSides;
    private final double expected;

    public ArchimedesTest(int input, double expected)
    {
        this.expected = expected;
        this.numSides= input;
    }

    @Test
    public void test() throws Exception {
        assertThat(Archimedes.approximatePi(numSides), is(expected));
    }
}