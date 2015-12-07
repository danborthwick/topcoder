import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubgridsCounter {

    static class Point {
        public int x;
        public int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static int howMany(int[] x, int[] y) {
        Set<Point> points = new HashSet();

        for (int i=0; i < x.length; i++) {
            Point p = new Point();
            p.x = x[i];
            p.y = y[i];
            points.add(p);
        }

        int smallestDimension = Math.min(
                Arrays.stream(x).max().getAsInt() - Arrays.stream(x).min().getAsInt(),
                Arrays.stream(y).max().getAsInt() - Arrays.stream(y).min().getAsInt());
        int maxGridSize = smallestDimension / 2;

        Point other = new Point();
        int gridsFound = 0;

        for (Point topLeft : points) {
            for (int gridSize = 1; gridSize <= maxGridSize; gridSize++) {
                boolean isGrid = true;

                for (int dx = 0; isGrid && dx < 3; dx++) {
                    for (int dy = 0; isGrid && dy < 3; dy++) {
                        other.x = topLeft.x + (dx * gridSize);
                        other.y = topLeft.y + (dy * gridSize);

                        isGrid &= points.contains(other);
                    }
                }
                if (isGrid) gridsFound++;
            }

        }


        return gridsFound;
    }
}
