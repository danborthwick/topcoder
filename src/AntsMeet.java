import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AntsMeet {

    public static int countAnts(int[] x, int[] y, String direction)
    {
        ArrayList<Ant> ants = new ArrayList(x.length);

        for (int i = 0; i < x.length; i++)
            ants.add(new Ant(x[i], y[i], direction.charAt(i)));

        ArrayList<Ant> toRemove = new ArrayList<>(ants.size());

        int minXNotWest, minYNotSouth, maxXNotEast, maxYNotNorth;
        int minXEast;
        int maxXWest;
        int minYNorth;
        int maxYSouth;

        do {
            toRemove.clear();

            for (Ant ant : ants) {
                for (Ant otherAnt : ants) {
                    if (ant != otherAnt && ant.x == otherAnt.x && ant.y == otherAnt.y) {
                        toRemove.add(ant);
                        toRemove.add(otherAnt);
                    }
                }
            }

            ants.removeAll(toRemove);

            if (ants.size() == 0)
                break;

            minXNotWest = 1000;
            maxXNotEast = -1000;
            minYNotSouth = 1000;
            maxYNotNorth = -1000;
            minXEast = Integer.MAX_VALUE;
            maxXWest = Integer.MIN_VALUE;
            minYNorth = Integer.MAX_VALUE;
            maxYSouth = Integer.MIN_VALUE;

            for (Ant ant : ants) {
                switch (ant.direction) {
                    case 'N':
                        ant.y++;
                        minYNorth = min(minYNorth, ant.y);
                        minXNotWest = min(minXNotWest, ant.x);
                        maxXNotEast = max(maxXNotEast, ant.x);
                        minYNotSouth = min(minYNotSouth, ant.y);
                        break;
                    case 'E':
                        ant.x++;
                        minXEast = min(minXEast, ant.x);
                        minXNotWest = min(minXNotWest, ant.x);
                        minYNotSouth = min(minYNotSouth, ant.y);
                        maxYNotNorth = max(maxYNotNorth, ant.y);
                        break;
                    case 'S':
                        ant.y--;
                        maxYSouth = max(maxYSouth, ant.y);
                        minXNotWest = min(minXNotWest, ant.x);
                        maxXNotEast = max(maxXNotEast, ant.x);
                        maxYNotNorth = max(maxYNotNorth, ant.y);
                        break;
                    case 'W':
                        ant.x--;
                        maxXWest = max(maxXWest, ant.x);
                        maxXNotEast = max(maxXNotEast, ant.x);
                        minYNotSouth = min(minYNotSouth, ant.y);
                        maxYNotNorth = max(maxYNotNorth, ant.y);
                        break;
                }
            }
        } while (minXEast <= maxXNotEast || maxXWest >= minXNotWest || minYNorth <= maxYNotNorth || maxYSouth >= minYNotSouth);

        return ants.size();
    }

    private static class Ant {
        private int x;
        private int y;
        private char direction;

        public Ant(int x, int y, char direction) {
            this.direction = direction;
            this.x = x;
            this.y = y;

        }
    }
}
