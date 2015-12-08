import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiamondHunt {
    public static int countDiamonds(String mine) {
        int inputLength = mine.length();
        Pattern pattern = Pattern.compile("<>");

        for (Matcher matcher = pattern.matcher(mine); matcher.find(); matcher = pattern.matcher(mine)) {
            mine = matcher.replaceAll("");
        }

        return (inputLength - mine.length()) / 2;
    }
}
