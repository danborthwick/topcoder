import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AaagmnrsTest
{

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return Arrays.asList(new Object[][]{
                {new String[]{"Aaagmnrs", "TopCoder", "anagrams", "Drop Cote"},
                        new String[]{"Aaagmnrs", "TopCoder"}},
                {new String[]{"SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok"},
                        new String[]{"SnapDragon vs tomek"}},
                {new String[]{"Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM"},
                        new String[]{"Radar ghost jilts Kim", "patched hers first"}}

        });
    }

    private final String[] expected;
    private final String[] input;

    public AaagmnrsTest(String input[], String expected[])
    {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception
    {
        assertThat(Aaagmnrs.anagrams(input), is(expected));
    }
}