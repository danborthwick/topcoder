import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BedroomFloorTest {

    private int x1, y1, x2, y2;
    private long expected;

    public BedroomFloorTest(int x1, int y1, int x2, int y2, long expected) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 0, 0, 5, 5, 5},
                { 0, 0, 10, 2, 5},
                { 8, 5, 20, 16, 27 },
                { 0, 0, 1000000, 10000000, 200000000000L }
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(BedroomFloor.numberOfSticks(x1, y1, x2, y2), is(expected));
    }
}