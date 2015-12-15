public class ConstructionFromMatches {

    public static final int LARGISH_INT = 1000000;

    public static int minimumCost(int[] cost, int[] top, int[] bottom) {

        final int M = top.length;
        final int THICKNESSES = cost.length;

        int[][][] minCostXTB = new int[M+1][THICKNESSES][THICKNESSES];

        for (int topI = 0; topI < THICKNESSES; topI++) {
            for (int bottomI = 0; bottomI < THICKNESSES; bottomI++) {
                minCostXTB[0][topI][bottomI] = cost[topI] + cost[bottomI];
            }
        }

        for (int x = 1; x < M+1; x++) {
            for (int t0 = 1; t0 <= THICKNESSES; t0++) {
                for (int b0 = 1; b0 <= THICKNESSES; b0++) {

                    for (int t1 = 1; t1 <= THICKNESSES; t1++) {
                        for (int b1 = 1; b1 <= THICKNESSES; b1++) {
                            int newCost = minCostXTB[x - 1][t0 - 1][b0 - 1] + costOf(cost, t0, b0, t1, b1, top[x - 1], bottom[x - 1]);
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

    private static int costOf(int[] cost, int t0, int b0, int t1, int b1, int topThickness, int bottomThickness) {

        //TODO: Cache horizontal cost a,b,c
        int remainingTop = topThickness - t0 - t1;
        int remainingBottom = bottomThickness - b0 - b1;

        //TODO: Is it really safe to assume f(t,b) = f(b,t)?
        int largerRemainder = Math.max(remainingTop, remainingBottom);
        int diff = Math.abs(remainingBottom - remainingTop);
        int minFound = LARGISH_INT;
        for (int a = 1, c = a + diff, b = largerRemainder - diff - 1;
             b > 0 && b <= cost.length && c <= cost.length;
             a++, b--, c++) {
            minFound = Math.min(minFound, cost[a-1] + cost[b-1] + cost[c-1]);
        }

        return minFound + cost[t1-1] + cost[b1-1];      //TODO: Don't add t1, b1 every time
    }
}
