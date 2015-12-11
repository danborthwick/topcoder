import java.util.Stack;

public class Rafting {
    public static double minRunningTime(int raftSpeed, int runSpeed, int[] x, int[] y, int k) {
        Helper helper = new Helper(raftSpeed, runSpeed, x, y);

        return helper.minRunningTime(-Double.MIN_VALUE, 0.0, k, Double.MIN_VALUE, Double.MIN_VALUE);
    }

    static class Helper {

        private final double raftSpeed;
        private final double runSpeed;
        private final int[] x;
        private final int[] y;
        private final int numSites;
        private final Stack<Integer> visited;
        private int differenceInSquaredSpeeds;

        public Helper(int raftSpeed, int runSpeed, int[] x, int[] y) {
            this.raftSpeed = raftSpeed;
            this.runSpeed = runSpeed;
            this.x = x;
            this.y = y;
            this.numSites = x.length;
            visited = new Stack();
            differenceInSquaredSpeeds = (runSpeed * runSpeed) - (raftSpeed * raftSpeed);
        }

        public double minRunningTime(double startX, double startY, int k, double manXPos, double raftXPos) {
            double dx = Math.abs(raftXPos - startX); //???abs???

            if (k == 1) {
                if (startY == 0) {
                    // Run from raft to nearest unvisited site and back
                    double dy = minimumUnvisitedY();
                    return 2.0 * Math.sqrt((dy * dy) / differenceInSquaredSpeeds);
                }
                else {

                }
            }

            return Double.MAX_VALUE;
        }

        private double minimumUnvisitedY() {
            int result = Integer.MAX_VALUE;

            for (int i=0; i < numSites; i++) {
                if (!visited.contains(i) && (y[i] < result))
                    result = y[i];
            }
            return result;
        }

        private double timeBackToRaft(double manXPos, double raftXPos) {
            double dx = manXPos - raftXPos;
            double a = differenceInSquaredSpeeds;
            double b = 2.0 * raftSpeed * dx;
            double c = dx * dx;
            double b2m4ac = (b * b) - (4.0 * a * c);

            double x1 = (-b + b2m4ac) / (2.0 * a);
            double x2 = (-b - b2m4ac) / (2.0 * a);

            if (x1 < 0)
                return x2 < 0 ? Double.MAX_VALUE : x2;
            else
                return x2 < 0 ? x1 : Math.min(x1, x2);
        }
    }
}
