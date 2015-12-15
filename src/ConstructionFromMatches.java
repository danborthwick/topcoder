import java.util.Arrays;

public class ConstructionFromMatches {

    public static int minimumCost(int[] cost, int[] top, int[] bottom) {
        return new Inner(cost, top, bottom).getMinimumCost();
    }

    private static class Inner {
        public static final int LARGISH_INT = 1000000;
        private final int M;
        private final int THICKNESSES;
        private final int[] cost;
        private final int[] top;
        private final int[] bottom;
        private final int[][][] minCostXTB;
        private final int[][] minHorizontalCostRTRB;


        public Inner(int[] cost, int[] top, int[] bottom) {
            this.cost = cost;
            this.top = top;
            this.bottom = bottom;
            M = top.length;
            THICKNESSES = cost.length;

            minCostXTB = initialiseMinCostXTB();
            minHorizontalCostRTRB = initialiseHorizontalCost();
        }

        private int[][][] initialiseMinCostXTB() {
            int[][][] xtb = new int[M + 1][THICKNESSES][THICKNESSES];

            for (int topI = 0; topI < THICKNESSES; topI++) {
                for (int bottomI = 0; bottomI < THICKNESSES; bottomI++) {
                    xtb[0][topI][bottomI] = cost[topI] + cost[bottomI];
                }
            }
            return xtb;
        }

        private int getMinimumCost() {
            for (int x = 1; x < M + 1; x++) {
                for (int t0 = 1; t0 <= THICKNESSES; t0++) {
                    for (int b0 = 1; b0 <= THICKNESSES; b0++) {

                        for (int t1 = 1; t1 <= THICKNESSES; t1++) {
                            for (int b1 = 1; b1 <= THICKNESSES; b1++) {

                                int newCost = minCostXTB[x - 1][t0 - 1][b0 - 1] + costOf(t0, b0, t1, b1, top[x - 1], bottom[x - 1]);
                                int before = minCostXTB[x][t1 - 1][b1 - 1];
                                if ((before == 0) || (newCost < before)) {
                                    minCostXTB[x][t1 - 1][b1 - 1] = newCost;
                                }
                            }
                        }
                    }
                }
            }

            int minFound = LARGISH_INT;
            for (int t = 0; t < THICKNESSES; t++) {
                for (int b = 0; b < THICKNESSES; b++) {
                    minFound = Math.min(minFound, minCostXTB[M][t][b]);
                }
            }
            return minFound == LARGISH_INT ? -1 : minFound;
        }

        private int[][] initialiseHorizontalCost() {
            int rMax = Math.max(
                    Arrays.stream(top).max().getAsInt(),
                    Arrays.stream(bottom).max().getAsInt());

            int[][] rtrb = new int[rMax][rMax];

            for (int rt = 0; rt < rMax; rt++) {
                for (int rb = 0; rb < rMax; rb++) {
                    int largerRemainder = Math.max(rt, rb);
                    int diff = Math.abs(rb - rt);
                    int minFound = LARGISH_INT;

                    for (int a = 1, c = a + diff, b = largerRemainder - diff - 1;
                         b > 0 && b <= THICKNESSES && c <= THICKNESSES;
                         a++, b--, c++) {
                        minFound = Math.min(minFound, cost[a - 1] + cost[b - 1] + cost[c - 1]);
                    }

                    rtrb[rt][rb] = minFound;
                }
            }

            return rtrb;
        }

        private int costOf(int t0, int b0, int t1, int b1, int topThickness, int bottomThickness) {
            int remainingTop = topThickness - t0 - t1;
            int remainingBottom = bottomThickness - b0 - b1;

            if ((remainingBottom < 0) || (remainingTop < 0))
                return LARGISH_INT;

            return minHorizontalCostRTRB[remainingTop][remainingBottom] + cost[t1 - 1] + cost[b1 - 1];      //TODO: Don't add t1, b1 every time
        }
    }
}
