import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CDPlayer {
    public static int isRandom(String[] songlist, int n) {
        StringIterator it = new StringIterator(songlist);
        Set<Character> found = new HashSet();

        for (int start = 0; start < n; start++) {
            it.setPosition(0);
            boolean isValid = true;
            found.clear();
            for (int i=0; i < start; i++) {
                char next = it.next();
                if (found.contains(next)) {
                    return -1;
                }
                else {
                    found.add(next);
                }
            }

            for (int i=start; i < it.length; i++) {
                if ((i - start) % n == 0) {
                    found.clear();
                }

                Character c = Character.valueOf(it.next());
                if (found.contains(c)) {
                    isValid = false;
                    break;
                }
                else
                    found.add(c);
            }
            if (isValid)
                return start;
        }
        return -1;
    }

    private static class StringIterator {
        private String[] songlist;
        public final int length;
        private int currentSubPos = 0;
        private int currentStringId = 0;

        public StringIterator(String[] songlist) {
            this.songlist = songlist;
            length = Arrays.stream(songlist).mapToInt((s) -> s.length()).sum();
        }

        public char next() {
            char result = songlist[currentStringId].charAt(currentSubPos);

            currentSubPos++;
            if (currentSubPos == songlist[currentStringId].length()) {
                currentStringId++;
                currentSubPos = 0;
            }

            return result;
        }

        public void setPosition(int pos) {
            currentStringId = 0;
            for (String subString : songlist) {
                if (pos < subString.length()) {
                    currentSubPos = pos;
                    break;
                }

                currentStringId++;
                pos -= subString.length();
            }
        }
    }
}
