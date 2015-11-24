import java.util.HashMap;
import java.util.Map;

public class ABoardGame {
    public static String whoWins(String[] input) {
        int N = input.length / 2;

        for (int region = 1; region <= N; region++)
        {
            int first = N - region;
            int last = N + region - 1;

            Map<Character, Integer> counts = new HashMap<>();
            counts.put('A', 0);
            counts.put('B', 0);
            counts.put('.', 0);

            //Top, Bottom
            for (int i=first; i <= last; i++) {
                update(input, counts, i, first);
                update(input, counts, i, last);
            }
            // Left, right
            for (int j=first; j <= last; j++) {
                update(input, counts, first, j);
                update(input, counts, last, j);
            }

            if (counts.get('A') > counts.get('B'))
                return "Alice";
            else if (counts.get('A') < counts.get('B'))
                return "Bob";
        }

        return "Draw";
    }

    private static void update(String[] input, Map<Character, Integer> counts, int i, int j) {
        char c = input[i].charAt(j);
        counts.put(c, counts.get(c) + 1);
    }
}
