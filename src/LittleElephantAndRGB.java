import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LittleElephantAndRGB {

    static class GSequence {
        public int start;
        public int count;

        public GSequence(int start) {
            this.start = start;
            this.count = 0;
        }

        public int end() { return start + count; }
    }
    public static long getNumber(String[] list, int minGreen) {

        char[] chars = String.join("", list).toCharArray();
        List<GSequence> sequences = parseSequences(chars);
        long numChars = chars.length;
        long result = 0;

        for (int firstId = 0; firstId < sequences.size(); firstId++) {
            GSequence first = sequences.get(firstId);

            for (int secondId = firstId + 1; secondId < sequences.size(); secondId++) {
                GSequence second = sequences.get(secondId);

                if ((first.count + second.count) >= minGreen) {
                    long possibleAs = first.start;
                    long separation = second.start - first.end();
                    long possibleBCs = factorial(separation - 1);
                    long possibleDs = numChars - second.end();
                }
            }
        }


        return sequences.size();
    }

    static Map<Long, Long> factorialCache = new HashMap();
    private static long factorial(long l) {
        if (factorialCache.containsKey(l)) {
            return factorialCache.get(l);
        }
        else

        return 0;
    }

    private static List<GSequence> parseSequences(char[] chars) {

        List<GSequence> sequences = new ArrayList();

        // Add dummy zero-length sequence at start to make pairs with sequences with count > minGreen
        sequences.add(new GSequence(0));

        for (int start = 0; start < chars.length; start++) {
            if (chars[start] == 'G') {
                GSequence sequence = new GSequence(start);
                sequences.add(sequence);

                while (chars[start + sequence.count] == 'G') {
                    sequence.count++;
                }

                start += sequence.count;
            }
        }
        return sequences;
    }
}
