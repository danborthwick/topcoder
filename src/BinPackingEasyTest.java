import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BinPackingEasyTest {

    private final int[] item;
    private final int expected;

    public BinPackingEasyTest(int[] item, int expected) {
        this.item = item;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{130, 140, 150, 160}, 2},
                {new int[]{101, 101, 101, 101, 101, 101, 101, 101, 101},5},
                {new int[]{101, 200, 101, 101, 101, 101, 200, 101, 200},6},
                {new int[]{123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198},8}

        });
    }

    @Test
    public void test() throws Exception {
        assertThat(BinPackingEasy.minBins(item), is(expected));
    }
}