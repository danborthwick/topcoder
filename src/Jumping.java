import java.util.Arrays;

public class Jumping {

    public static String ableToGet(int x, int y, int[] jumpLengths) {

        int max = Arrays.stream(jumpLengths).max().getAsInt();
        int sum = Arrays.stream(jumpLengths).sum();
        int sumOfOthers = sum - max;

        double actual = Math.sqrt((x * x) + (y * y));
        double minPossible;
        if (jumpLengths.length > 1) {
            minPossible = (sumOfOthers > max) ? 0 : max - sumOfOthers;
        }
        else {
            minPossible = sum;
        }

        boolean possible = (actual >= minPossible) && (actual <= sum);

        return possible ? "Able" : "Not able";
    }
}
