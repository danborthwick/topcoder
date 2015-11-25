import java.util.ArrayList;

public class AlphabetPath
{

    public static final int terminator = 'Z' + 1;

    static class Point
    {
        public  int x;
        public int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static String doesItExist(String[] input)
    {
        Point currentPoint = new Point(-1, -1);

        for (currentPoint.y = 0; currentPoint.y < input.length && currentPoint.x == -1; currentPoint.y++) {
            int candidateX = input[currentPoint.y].indexOf('A');
            if (candidateX != -1)
            {
                currentPoint.x = candidateX;
                break;
            }
        }

        if (currentPoint.x == -1)
            return "NO";

        ArrayList<Point> deltas = new ArrayList<>(4);
        deltas.add(new Point(-1, 0));
        deltas.add(new Point(0, -1));
        deltas.add(new Point(1, 0));
        deltas.add(new Point(0, 1));

        for (char next = 'B'; next != terminator; next++)
        {
            Point nextPoint = new Point(-1, -1);
            for (Point delta : deltas) {
                nextPoint.x = currentPoint.x + delta.x;
                nextPoint.y = currentPoint.y + delta.y;
                if (get(input, nextPoint) == next) {
                    currentPoint.x = nextPoint.x;
                    currentPoint.y = nextPoint.y;
                    break;
                }
            }

            if (nextPoint.x != currentPoint.x || nextPoint.y != currentPoint.y)
                return "NO";
        }

        return "YES";
    }

    static char get(String[] input, Point p)
    {
        if (p.y >= 0 && p.y < input.length)
            if (p.x >= 0 && p.x < input[0].length())
                return input[p.y].charAt(p.x);

        return terminator;
    }
}
