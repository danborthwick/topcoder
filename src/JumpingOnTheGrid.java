import java.util.Arrays;

public class JumpingOnTheGrid {
    private static final char START = '*';
    private static final char END = '$';
    private static final char WALL = '#';

    static class Dynamic {

        private final long[][] maxE;
        private final String[] grid;
        private final int E;
        private final int T;

        public Dynamic(final String[] grid, final int E, final int T) {
            this.grid = grid;
            this.E = E;
            this.T = T;

            maxE = new long[T + 1][grid.length * grid.length];
            for (long[] longs : maxE) {
                Arrays.fill(longs, -1);
            }

            maxE[0][indexOf(START)] = E;
        }

        public void compute() {
            for (int t = 0; t < T; t++) {
                for (int y = 0; y < grid.length; y++) {
                    for (int x = 0; x < grid.length; x++) {

                        long eFrom = getMaxE(t, x, y);
                        if (eFrom >= 0) {
                            int tTo = t + 1;

                            step(tTo, x, y, 0, -1, eFrom);
                            step(tTo, x, y, 0, 1, eFrom);
                            step(tTo, x, y, -1, 0, eFrom);
                            step(tTo, x, y, 1, 0, eFrom);

                            setMaxE(tTo, x, y, eFrom + energyIncreaseAt(x, y));
                        }
                    }
                }
            }
        }

        private long energyIncreaseAt(int x, int y) {
            char c = grid[y].charAt(x);
            if (c >= '0' && c <= '9') {
                return c - '0';
            }
            else if (c >= 'a' && c <= 'z') {
                return c - 'a' + 10;
            }
            else if (c >= 'A' && c <= 'Z') {
                return c - 'A' + 36;
            }
            else {
                return 0;
            }
        }

        public long result() {
            return maxE[T][indexOf(END)];
        }

        private void step(int tTo, int xFrom, int yFrom, int dx, int dy, long eFrom) {
            for (int xTo = xFrom + dx, yTo = yFrom + dy;
                 validCell(xTo, yTo) && canLandOn(xTo, yTo);
                 xTo += dx, yTo += dy) {

                int dist = Math.abs(yTo - yFrom) + Math.abs(xTo - xFrom);
                long eTo = eFrom - (dist * dist);

                if (eTo > getMaxE(tTo, xTo, yTo)) {
                    setMaxE(tTo, xTo, yTo, eTo);
                }
            }
        }

        private void setMaxE(int t, int x, int y, long e) {
            maxE[t][y * grid.length + x] = e;
        }

        private long getMaxE(int t, int x, int y) {
            return maxE[t][y * grid.length + x];
        }

        private boolean validCell(int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid.length;
        }

        private boolean canLandOn(int x, int y) {
            return grid[y].charAt(x) != WALL;
        }

        private int indexOf(char c) {
            for (int y=0; y < grid.length; y++) {
                int x = grid[y].indexOf(c);
                if (x >= 0) {
                    return (y * grid.length) + x;
                }
            }
            return -1;
        }
    }


    public static long maxEnergy(final String[] grid, final int E, final int T) {

        // TODO: Handle large T
        if (T > 1000) return -1;

        Dynamic dynamic = new Dynamic(grid, E, T);
        dynamic.compute();

        return dynamic.result();
    }

}
