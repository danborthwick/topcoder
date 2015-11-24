public class EasyHomework {
    public static String determineSign(int[] input) {

        boolean isPositive = true;

        for (int i : input)
        {
            if (i == 0) return "ZERO";

            if (i < 0) isPositive = !isPositive;
        }

        return isPositive ? "POSITIVE" : "NEGATIVE";
    }
}
