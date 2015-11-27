import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class grafixCorruptTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new String[] {"cat", "cab", "lab"},
                "dab",
                1},
//        The word "dab" has two letters in the same position as both "cab" and "lab", but "cab" comes first.
//        1)
        { new String[] {"cat", "cab", "lab"},
        "lag",
        2},
//        Here, "lab" is the best fit.
//        2)
            { new String[] {"cat", "cab", "lab"},
        "bic",
        -1},
//        The word "bic" contains a 'c' and a 'b', but neither character is at the same position in any dictionary word.
//        3)
                { new String[] {"zkv", "izs", "fed", "waa", "ttx", "bgt", "quy", "dtq", "dgo", "yrs", "cid", "nln", "pvz", "txt", "zun", "erd", "jen", "klh", "kxy", "emf", "mqt", "lza", "dzb", "ndx", "vfr", "jhs", "dkm", "elb"},
        "cwd",
        10},
//        4)
                    { new String[] {"zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw", "ovctbzx", "sfzekhh", "lxzixjk", "jixdpik", "bkianck", "laclyin", "uqmdkfx", "dimswqo", "fojhetr", "grntrce", "obdtqwx", "bhojwcy", "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki", "uxdnslh", "wudrusz", "uwxbvou", "ouytqun", "pjdexqe", "xraaqdw", "lxmoncl", "sjnjfgb", "qrlqgvc", "fgvoadm", "yohsrxw", "udpvrsr", "mklucgt"},
        "vklikgf",
        36}
        });
    }

    private final String[] dictionary;
    private final String word;
    private final int expected;

    public grafixCorruptTest(String[] dictionary, String word, int expected)
    {
        this.dictionary = dictionary;
        this.word = word;
        this.expected = expected;
    }

    @Test
    public void test() throws Exception {
        assertThat(grafixCorrupt.selectWord(dictionary, word), is(expected));
    }
}