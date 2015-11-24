import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class EllysBullsTest {

    private String[] guesses;
    private int[] bulls;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[] {"1234", "4321", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"},
                new int[] {2, 1, 1, 0, 2, 0, 0, 0, 1, 0, 0},
                "1337" },
                {new String[] {"0000", "1111", "2222"},
                        new int[] {2, 2, 2},
        "Liar" },
                {        new String[] {"666666", "666677", "777777", "999999"},
                        new int[] {2, 3, 1, 0},
        "Ambiguity" },
                {   new String[]   {"000", "987", "654", "321", "100", "010"},
                        new int[] {2, 1, 0, 0, 1, 1},
        "007" },
                {    new String[]    {"28", "92", "70", "30", "67", "63", "06", "65", "11", "06", "88", "48", "09", "65", "48", "08"},
                        new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        "54" },
                {    new String[]     {"0294884", "1711527", "2362216", "7666148", "7295642", "4166623", "1166638", "2767693", "8650248", "2486509", "6138934", "4018642", "6236742", "2961643", "8407361", "2097376", "6575410", "6071777", "3569948", "2606380"},
                        new int[]  {1, 0, 1, 3, 4, 4, 3, 2, 1, 1, 0, 4, 4, 3, 0, 0, 0, 0, 2, 1},
        "4266642" },
        });
    }

    private final String expected;

    public EllysBullsTest(String[] guesses, int[] bulls, String expected)
    {
        this.guesses = guesses;
        this.bulls = bulls;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(EllysBulls.getNumber(guesses, bulls), is(expected));
    }
}