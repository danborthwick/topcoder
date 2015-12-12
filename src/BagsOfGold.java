import java.util.Arrays;

public class BagsOfGold {
    public static int netGain(int[] bags) {

        int[] eAMinusB = Arrays.copyOf(bags, bags.length);
        int numTurns = bags.length;

        for (int n = numTurns - 2; n >= 0; n--) {
            int length = numTurns - n;
            for (int s=0; s <= n; s++) {

                int eStart = bags[s] - eAMinusB[s + 1];
                int eEnd = bags[s + length - 1] - eAMinusB[s];
                eAMinusB[s] = Math.max(eStart, eEnd);
            }
        }
        return eAMinusB[0];
    }
}
