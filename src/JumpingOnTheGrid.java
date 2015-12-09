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
                for (int yFrom = 0; yFrom < grid.length; yFrom++) {
                    for (int xFrom = 0; xFrom < grid.length; xFrom++) {
                        long eFrom = maxE[t][yFrom * grid.length + xFrom];

                        if (eFrom > 0) {
                            eMaxStep(xFrom, yFrom, 0, -1, eFrom, t + 1);
                            eMaxStep(xFrom, yFrom, 0, 1, eFrom, t + 1);
                            eMaxStep(xFrom, yFrom, -1, 0, eFrom, t + 1);
                            eMaxStep(xFrom, yFrom, 1, 0, eFrom, t + 1);
                        }
                    }
                }
            }


        }

        public long result() {
            return maxE[T][indexOf(END)];
        }

        private void eMaxStep(int xFrom, int yFrom, int dx, int dy, long eFrom, int tTo) {
            for (int xTo = xFrom + dx, yTo = yFrom + dy;
                 validCell(xTo, yTo) && canLandOn(xTo, yTo);
                 xTo += dx, yTo += dy) {
                int dist = Math.abs(yTo - yFrom) + Math.abs(xTo - xFrom);
                long eTo = eFrom - (dist * dist);
                long eOrig = maxE[tTo][yTo * grid.length + xTo];

                if (eTo > eOrig) {
                    maxE[tTo][yTo * grid.length + xTo] = eTo;
                }
            }
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
