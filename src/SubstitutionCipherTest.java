import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SubstitutionCipherTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"CAT",
                        "DOG",
                        "GOD",
                        "TAC"},
                {"BANANA",
                        "METETE",
                        "TEMP",
                        ""},
                {"THEQUICKBROWNFOXJUMPSOVERTHELAZYHOG",
                        "UIFRVJDLCSPXOGPYKVNQTPWFSUIFMBAZIPH",
                        "DIDYOUNOTICESKIPPEDLETTER",
                        "CHCXNTMNSHBDRJHOODCKDSSDQ"},
        });
    }

    private final String expected;
    private final String a;
    private final String b;
    private final String y;

    public SubstitutionCipherTest(String a, String b, String y, String expected)
    {
        this.expected = expected;
        this.a = a;
        this.b = b;
        this.y = y;
    }

    @Test
    public void test() throws Exception {
        assertThat(SubstitutionCipher.decode(a, b, y), is(expected));
    }
}