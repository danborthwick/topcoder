import java.util.Arrays;

public class Badgers
{
    public static int feedMost(int[] hunger, int[] greed, int totalFood)
    {
        int maxFound = 0;
        int maxBadgers = hunger.length;

        for (int badgers = 1; badgers < maxBadgers; badgers++)
        {
            int[] scores = hunger.clone();

            for (int i=0; i < maxBadgers; i++)
                scores[i] += (badgers - 1) * greed[i];

            Arrays.sort(scores);

            int minScore = 0;
            for (int i=0; i < badgers; i++)
                minScore += scores[i];

            if (minScore <= totalFood)
                maxFound = badgers;
        }

        return maxFound;
    }
}
