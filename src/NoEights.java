import java.util.ArrayList;
import java.util.List;

public class NoEights {
    public static int smallestAmount(int low, int high) {
        List<Integer> lowDigits = getDigits(low);
        List<Integer> highDigits = getDigits(high);

        int commonDigitCount = Math.min(lowDigits.size(), highDigits.size());
        int sharedEights = 0;

        for (int digit = 0; digit < commonDigitCount; digit++)
        {
            if (lowDigits.get(digit) == 8 && highDigits.get(digit) == 8) {
                sharedEights++;
            }
        }
        return sharedEights;
    }

    private static List<Integer> getDigits(int i) {
        List<Integer> digits = new ArrayList();
        while (i > 0) {
            digits.add(i % 10);
            i /= 10;
        }
        return digits;
    }
}
