import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlurredDartboard {

    static class Throw {
        private final int score;
        private final int darts;

        public Throw(int score, int darts) {
            this.score = score;
            this.darts = darts;
        }

        public int getScore() { return score; }
        public int getDarts() { return darts; }

        public double scorePerDart() { return score / darts; }

    }

    public static int minThrows(int[] points, int p) {
        List<Throw> availableThrows = makeAvailableThrows(points);

        int remainingScore = p;
        int availableThrowIndex = 0;
        Stack<Throw> throwStack = new Stack();

        while (remainingScore != 0) {
            while ((availableThrowIndex < availableThrows.size())
                    && (availableThrows.get(availableThrowIndex).getScore() > remainingScore)) {
                availableThrowIndex++;
            }

            if (availableThrowIndex < availableThrows.size()) {
                Throw pushed = availableThrows.get(availableThrowIndex);
                throwStack.push(pushed);
                remainingScore -= pushed.score;
            }
            else {
                Throw popped = throwStack.pop();
                availableThrowIndex = availableThrows.indexOf(popped) + 1;
                remainingScore += popped.score;
            }
        }

        return throwStack.stream().mapToInt(Throw::getDarts).sum();
    }

    private static List<Throw> makeAvailableThrows(int[] points) {
        List<Throw> availableThrows = new ArrayList();

        for (int point : points) {
            if (point > 0) {
                availableThrows.add(new Throw(point, 1));
            }
        }

        int sumOfKnownSectors = availableThrows.stream().mapToInt(Throw::getScore).sum();
        int sumOfAllSectors = ((points.length + 1) * points.length) / 2;
        int numUnknownSectors = points.length - availableThrows.size();

        if (numUnknownSectors > 0) {
            int sumOfUnknownSectors = sumOfAllSectors - sumOfKnownSectors;
            availableThrows.add(new Throw(sumOfUnknownSectors, numUnknownSectors));
        }

        availableThrows.sort((throw1, throw2) -> Double.compare(throw2.scorePerDart(), throw1.scorePerDart()));
        return availableThrows;
    }
}
