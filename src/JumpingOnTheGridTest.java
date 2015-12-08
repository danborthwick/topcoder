import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class JumpingOnTheGridTest {

    private final String[] grid;
    private final int E;
    private final int T;
    private final long expected;

    public JumpingOnTheGridTest(String[] grid, int e, int t, long expected) {
        this.grid = grid;
        E = e;
        T = t;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { //0)
        new String[]{"*$.", "#1.", "..."},1,1,0},
//        Petya moves his character directly to the target cell. Note that with power 0 the character is still alive.
        { //1)
        new String[]{"*$.", "#.1", "..."},1,1000000000,0},
//        Even though T is large now, after the first step Petya has no more power, so he cannot reach the charging station.
        { //2)
        new String[]{"*$.", "#2.", "..."},2,10,13},
//        The optimal strategy is to move one step to the right, then one step down, then to wait for 7 seconds on the charging station, and finally to move one step up.
        { //3)
        new String[]{"*$.", "#aA", "..."},2,10,151},
        { //4)
        new String[]{"*..Z", "##..", "#...", "...$"},8,4,55},
//        One of the possible optimal strategies is to jump by 2 cells to the right, then jump 1 more cell to the right to reach the charging station. After that we can wait for 1 second there and then jump by 3 cells directly to the target cell.
        { //5)
        new String[]{"#*#..", "####.", "ZZZZZ", "...$."},1000000000,1000000000,-1},
        { //6)
        new String[]{"#*#..", "#.##.", "ZZZZZ", "...$."},4,1000000000,60999999812L}
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(JumpingOnTheGrid.maxEnergy(grid, E, T), is(expected));
    }
}