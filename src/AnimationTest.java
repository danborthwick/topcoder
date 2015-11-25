import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AnimationTest
{

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 2, "..R....", 
                new String[]{ "..X....", "....X..", "......X", "......." }},
                { 3,
        "RR..LRL",
        new String[]{ "XX..XXX", ".X.XX..", "X.....X", "......." }},
                {2,
        "LRLR.LRLR",
        new String[]{ "XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........." }},
                {10,
        "RLRLRLRLRL",
        new String[]{ "XXXXXXXXXX", ".........." }},
                {        1,
        "...",
        new String[]{ "..." }},
                {        1,
        "LRRL.LR.LRR.R.LRRL.",
        new String[]{ "XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX", "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X", ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..", "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..", "..X.............XX.", ".X...............XX", "X.................X", "..................." }}
        });
    }

    private final String[] expected;
    private final int speed;
    private final String input;

    public AnimationTest(int speed, String input, String[] expected)
    {
        this.speed = speed;
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws Exception {
        assertThat(Animation.animate(speed, input), is(expected));
    }
}