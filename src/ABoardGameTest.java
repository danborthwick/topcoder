import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ABoardGameTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Alice", new String[]{".....A", "......", "..A...", "...B..", "......", "......"}},
                {"Bob", new String[]{"AAAA", "A.BA", "A..A", "AAAA"}},
                {"Draw", new String[]{"..", ".."}},
                {"Alice", new String[]{"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."}},
                {"Bob", new String[]{"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"}},
                {"Draw", new String[]{"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"}},
        });
    }

    private final String expected;
    private final String[] input;

    public ABoardGameTest(String expected, String[] input)
    {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(ABoardGame.whoWins(input), is(expected));
    }
}