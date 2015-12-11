import java.util.Arrays;

public class JumpingOnTheGrid {
    private static final char START = '*';
    private static final char END = '$';
    private static final char WALL = '#';

    static class Dynamic {

        private final long[][] maxE;
        private final String[] grid;
        private final int width, height;
        private final int maxSteps;

        public Dynamic(final String[] grid, final int E, final int maxSteps) {
            this.grid = grid;
            this.width = grid[0].length();
            this.height = grid.length;
            this.maxSteps = maxSteps;

            maxE = new long[maxSteps + 1][width * height];
            for (long[] longs : maxE) {
                Arrays.fill(longs, -1);
            }

            maxE[0][indexOf(START)] = E;
        }

        public void compute(int prefixSteps) {
            for (int t = 0; t < maxSteps; t++) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {

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

        public long result(int steps) {
            return maxE[steps][indexOf(END)];
        }

        private void step(int tTo, int xFrom, int yFrom, int dx, int dy, long eFrom) {
            for (int xTo = xFrom + dx, yTo = yFrom + dy;
                 validCell(xTo, yTo) && canLandOn(xTo, yTo);
                 xTo += dx, yTo += dy) {

                int dist = Math.abs(yTo - yFrom) + Math.abs(xTo - xFrom);
                long eTo = eFrom - (dist * dist);

                setMaxE(tTo, xTo, yTo, eTo);
            }
        }

        public void computeWait(int prefixSteps, int waitSteps) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    long eFrom = getMaxE(prefixSteps, x, y);

                    long eTo = (eFrom >= 0) ? eFrom + energyIncreaseAt(x, y) * waitSteps : eFrom;
                    setMaxE(0, x, y, eTo);
                }
            }

            // Reset subsequent t's
            for (int t = 1; t < maxE.length; t++) {
                Arrays.fill(maxE[t], -1);
            }
        }

        private void setMaxE(int t, int x, int y, long e) {
            if (e > maxE[t][y * width + x])
                maxE[t][y * width + x] = e;
        }

        private long getMaxE(int t, int x, int y) {
            return maxE[t][y * width + x];
        }

        private boolean validCell(int x, int y) {
            return x >= 0 && x < width && y >= 0 && y < height;
        }

        private boolean canLandOn(int x, int y) {
            return grid[y].charAt(x) != WALL;
        }

        private int indexOf(char c) {
            for (int y=0; y < height; y++) {
                int x = grid[y].indexOf(c);
                if (x >= 0) {
                    return (y * width) + x;
                }
            }
            return -1;
        }
    }


    public static long maxEnergy(final String[] grid, final int E, final int T) {

        final int numCells = grid.length * grid[0].length();

        final int prefixSteps = Math.min(3 * numCells + 61, T);
        final int waitSteps = T - (4 * numCells) - 61;
        final int suffixSteps = numCells;
        long result;

        Dynamic dynamic = new Dynamic(grid, E, Math.max(prefixSteps, suffixSteps));
        dynamic.compute(prefixSteps);

        if (waitSteps > 0) {
            dynamic.computeWait(prefixSteps, waitSteps);
            dynamic.compute(suffixSteps);
            result = dynamic.result(suffixSteps);
        }
        else {
            result = dynamic.result(prefixSteps);
        }

        return result;
    }

}
