import java.util.Arrays;

public class JumpingOnTheGrid {
    private static final int START = '*';

    public static long maxEnergy(final String[] grid, final int E, final int T) {

        // TODO: Handle large T
        if (T > 1000) return -1;

        long[][] maxE = new long[grid.length * grid.length][T + 1];
        for (long[] longs : maxE) {
            Arrays.fill(longs, -1);
        }

        maxE[0][indexOfStartCell(grid)] = E;

        for (int t = 0; t <= T; t++) {

        }

        return -1;
    }

    private static int indexOfStartCell(String[] grid) {
        for (int y=0; y < grid.length; y++) {
            int x = grid[y].indexOf(START);
            if (x >= 0) {
                return (y * grid.length) + x;
            }
        }
        return -1;
    }
}
