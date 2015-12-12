import java.util.Arrays;

public class CostOfDancing {
    public static int minimum(int k, int[] danceCost) {
        Arrays.sort(danceCost);

        int cost = 0;
        for (int i = 0; i < k; i++) {
            cost += danceCost[i];
        }
        return cost;
    }
}
