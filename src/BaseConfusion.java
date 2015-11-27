import java.util.Arrays;

public class BaseConfusion {
    public static long sum(int m, int n, int b) {
        long[] digits = new long[32];
        long sum = 0;

        for (int i = m; i <= n; i++)
        {
            set(digits, b, i);
            sum += get(digits, b + 1);
        }

        return sum;
    }

    private static long get(long[] digits, int base) {
        long result = 0L;
        for (int d = 0; d < digits.length; d++)
        {
            long dec = (long) Math.pow(base, d);
            result += digits[d] * dec;
        }

        return result;
    }

    private static void set(long[] digits, int base, int i) {
        Arrays.fill(digits, 0);
        for (int d = digits.length - 1; d >= 0 && i > 0; d--) {
            long dec = (long) Math.pow(base, d);
            digits[d] = i / dec;
            i -= dec * digits[d];
        }
    }
}
