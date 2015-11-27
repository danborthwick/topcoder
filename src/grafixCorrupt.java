public class grafixCorrupt {
    public static int selectWord(String[] dictionary, String word) {

        int result = -1;
        int maxSharedLetters = 0;

        for (int candidateIndex = 0; candidateIndex < dictionary.length; candidateIndex++)
        {
            int sharedLetters = sharedLetters(dictionary[candidateIndex], word);
            if (sharedLetters > maxSharedLetters) {
                maxSharedLetters = sharedLetters;
                result = candidateIndex;
            }
        }

        return result;
    }

    private static int sharedLetters(String a, String b) {
        int shared = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                shared++;
            }
        }
        return shared;
    }
}
