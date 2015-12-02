import java.util.Arrays;

public class BinPackingEasy {
    public static int minBins(int[] item) {
        Arrays.sort(item);

        int pairsFound = 0;

        for (int firstIndex = 0, lastIndex = item.length - 1;
                firstIndex < lastIndex; )
        {
            if (item[firstIndex] + item[lastIndex] <= 300) {
                firstIndex++;
                lastIndex--;
                pairsFound++;
            }
            else if ((item[firstIndex] - 101) < (200 - item[lastIndex])) {
                firstIndex++;
            }
            else {
                lastIndex--;
            }
        }

        return item.length - pairsFound;
    }
}
