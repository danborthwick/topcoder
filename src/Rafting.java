import java.util.Stack;

public class Rafting {
    public static double minRunningTime(int raftSpeed, int runSpeed, int[] x, int[] y, int k) {
        Helper helper = new Helper(raftSpeed, runSpeed, x, y);

        Stack<Integer> visits = new Stack();
        return helper.minRunningTime(visits, -Double.MIN_VALUE, 0.0, k, Double.MIN_VALUE);
    }

    static class Helper {

        private final int raftSpeed;
        private final int runSpeed;
        private final int[] x;
        private final int[] y;
        private final int numSites;

        public Helper(int raftSpeed, int runSpeed, int[] x, int[] y) {
            this.raftSpeed = raftSpeed;
            this.runSpeed = runSpeed;
            this.x = x;
            this.y = y;
            this.numSites = x.length;
        }

        public double minRunningTime(Stack<Integer> visits, double startX, double startY, int k, double raftXPos) {
            if (k == 0) {
                // Run back to raft
                double dx = Math.abs(raftXPos - startX); //???abs???
                double tSquared = ((dx * dx) + (startY * startY) - (2.0 * dx * raftSpeed)) / (runSpeed - 1.0);

                return tSquared >= 0 ? Math.sqrt(tSquared) : Double.MAX_VALUE;
            }

            return Double.MAX_VALUE;
        }
    }
}
