public class ABBADiv1
{
    public static String canObtain(String initial, String target)
    {
        String targetReversed = reverse(target);
        return helper(initial, target, targetReversed) ? "Possible" : "Impossible";
    }

    private static boolean helper(String initial, String target, String targetReversed)
    {
        if (initial.equals(target))
            return true;

        String aPos = initial + "A";
        boolean result = false;

        if (target.contains(aPos) || targetReversed.contains(aPos))
        {
            result = helper(aPos, target, targetReversed);
        }

        if (!result)
        {
            String bPos = reverse(initial + "B");
            if (target.contains(bPos) || targetReversed.contains(bPos))
            {
                result = helper(bPos, target, targetReversed);
            }
        }

        return result;

    }

    private static String reverse(String input)
    {
        byte[] inputBytes = input.getBytes();
        byte[] outBytes = new byte[inputBytes.length];

        for (int i=0; i < inputBytes.length; i++) {
            outBytes[inputBytes.length - i - 1] = inputBytes[i];
        }

        return new String(outBytes);
    }
}
