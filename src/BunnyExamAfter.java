public class BunnyExamAfter {
    public static int getMaximum(String black, String grey, String white) {
        int result = 0;

        for (int i=0; i < black.length(); i++) {
            if (grey.charAt(i) != black.charAt(i)) {
                result += grey.charAt(i) == white.charAt(i) ? 2 : 1;
            }
            else if (white.charAt(i) != black.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
