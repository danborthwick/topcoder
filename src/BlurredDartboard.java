import java.util.Arrays;

public class BlurredDartboard {

    public static int minThrows(int[] points, int p) {
        int maxSingleThrow = 0;
        int unknownPoints = ((points.length + 1) * points.length) / 2;
        int numUnknownSectors = points.length;
        Arrays.sort(points);

        for (int point : points) {
            if (point > 0) {
                if (point > maxSingleThrow) {
                    maxSingleThrow = point;
                }
                unknownPoints -= point;
                numUnknownSectors--;
            }
        }

        int dartsThrown = 0;
        int remainingScore = p;

        if ((numUnknownSectors > 0) && ((double)unknownPoints / numUnknownSectors) > maxSingleThrow) {
            int numSpreads = remainingScore / unknownPoints;
            remainingScore -= numSpreads * unknownPoints;
            dartsThrown = numSpreads * numUnknownSectors;
        }

        if (remainingScore > 0) {
            int knownMaxSingleThrows = (int) Math.ceil((double)remainingScore / maxSingleThrow);

            int unknownRequired = remainingScore;
            int worstCaseUnknownThrows = 0;

            for (int unknownPointCandidate = 1; unknownRequired > 0 && unknownPointCandidate <= points.length; unknownPointCandidate++) {
                if (isKnown(unknownPointCandidate, points)) {
                    continue;
                }

                worstCaseUnknownThrows++;
                unknownRequired -= unknownPointCandidate;
            }

            if (worstCaseUnknownThrows == 0)
                worstCaseUnknownThrows = Integer.MAX_VALUE;

            dartsThrown += Math.min(knownMaxSingleThrows, worstCaseUnknownThrows);
        }

        return dartsThrown;
    }

    private static boolean isKnown(int i, int[] points) {
        for (int point : points) {
            if (i == point) return true;
        }

        return false;
    }
}
