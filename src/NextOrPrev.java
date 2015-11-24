import java.util.*;

public class NextOrPrev {

    static class CPair
    {
        public char from;
        public char to;

        public CPair(char from, char to) {
            this.from = from;
            this.to = to;
        }
    }

    public static int getMinimum(int nextCost, int prevCost, String start, String goal)
    {
        if (start.length() != goal.length()) return -1;

        List<CPair> nextPairs = new ArrayList<>();
        List<CPair> prevPairs = new ArrayList<>();
        List<CPair> samePairs = new ArrayList<>();

        for (int i =0; i < start.length(); i++)
        {
            CPair pair = new CPair(start.charAt(i), goal.charAt(i));

            if (pair.from < pair.to)
            {
                nextPairs.add(pair);
            }
            else if (pair.from > pair.to)
            {
                prevPairs.add(pair);
            }
            else
            {
                samePairs.add(pair);
            }
        }

        for (CPair nextPair : nextPairs) {
            for (CPair prevPair : prevPairs) {
                if (intersects(nextPair, prevPair))
                    return -1;
            }
        }

        for (CPair nextPair : nextPairs) {
            for (CPair prevPair : samePairs) {
                if (intersects(nextPair, prevPair))
                    return -1;
            }
        }
        for (CPair nextPair : samePairs) {
            for (CPair prevPair : prevPairs) {
                if (intersects(nextPair, prevPair))
                    return -1;
            }
        }

        int cost = 0;
        for (CPair nextPair : nextPairs) {
            cost += (nextPair.to - nextPair.from) * nextCost;
        }
        for (CPair prevPair : prevPairs) {
            cost += (prevPair.from - prevPair.to) * prevCost;
        }

        return cost;
    }

    private static boolean intersects(CPair nextPair, CPair prevPair) {
        return !((nextPair.to < prevPair.to) || (nextPair.from > prevPair.from));
    }

}
