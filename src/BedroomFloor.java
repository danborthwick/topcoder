import java.util.HashMap;
import java.util.Map;

public class BedroomFloor {
    public static long numberOfSticks(int x1, int y1, int x2, int y2) {

        Map<Integer, Long> requiredLengths = new HashMap();
        for (int i=1; i<=5; i++)
            requiredLengths.put(i, 0L);

        long xWholeStart = (long) (Math.ceil(x1 / 5.0) * 5.0);
        long yWholeStart = (long) (Math.ceil(y1 / 5.0) * 5.0);
        long xWholeEnd = (long) (Math.floor(x2 / 5.0) * 5.0);
        long yWholeEnd = (long) (Math.floor(y2 / 5.0) * 5.0);

        // Top Left
        addPartialTile(x1, y1, xWholeStart, yWholeStart, requiredLengths);
        // Top right
        addPartialTile(xWholeEnd, y1, x2, yWholeStart, requiredLengths);
        // Bottom left
        addPartialTile(x1, yWholeEnd, xWholeStart, y2, requiredLengths);
        // Bottom right
        addPartialTile(xWholeEnd, yWholeEnd, x2, y2, requiredLengths);

        // Top, bottom sides
        for (long x = xWholeStart; x < xWholeEnd; x += 5) {
            addPartialTile(x, y1, x + 5, yWholeStart, requiredLengths);
            addPartialTile(x, yWholeEnd, x + 5, y2, requiredLengths);
        }
        // Left, right sides
        for (long y = yWholeStart; y < yWholeEnd; y += 5) {
            addPartialTile(x1, y, xWholeStart, y + 5, requiredLengths);
            addPartialTile(xWholeEnd, y, x2, y + 5, requiredLengths);
        }
        // Whole panels
        long numFullSticks = (xWholeEnd - xWholeStart) * (yWholeEnd - yWholeStart) / 5L;
        increment(requiredLengths, 5, numFullSticks);

        return getFullSticksNeeded(requiredLengths);
    }

    private static long getFullSticksNeeded(Map<Integer, Long> requiredLengths) {
        consolidate(requiredLengths, new int[] {4, 1}, new int[] {1, 1});
        consolidate(requiredLengths, new int[] {3, 2}, new int[] {1, 1});
        consolidate(requiredLengths, new int[] {3, 1}, new int[] {1, 1});
        consolidate(requiredLengths, new int[] {2, 1}, new int[] {2, 1});
        consolidate(requiredLengths, new int[] {2}, new int[] {2});
        consolidate(requiredLengths, new int[] {2, 1}, new int[] {1, 3});
        consolidate(requiredLengths, new int[] {2, 1}, new int[] {1, 2});
        consolidate(requiredLengths, new int[] {2, 1}, new int[] {1, 1});
        consolidate(requiredLengths, new int[]{1}, new int[]{5});
        consolidate(requiredLengths, new int[]{1}, new int[]{4});
        consolidate(requiredLengths, new int[]{1}, new int[]{3});
        consolidate(requiredLengths, new int[]{1}, new int[]{2});

        return requiredLengths.values().stream().mapToLong(Long::longValue).sum();
    }

    private static void consolidate(Map<Integer, Long> planks, int[] lengths, int[] counts) {
        long possibleMatches = Integer.MAX_VALUE;
        for (int i=0; i < lengths.length; i++) {
            possibleMatches = Math.min(possibleMatches, planks.get(lengths[i]) / counts[i]);
        }

        if (possibleMatches != 0 && possibleMatches != Integer.MAX_VALUE) {
            increment(planks, 5, possibleMatches);
            for (int i=0; i < lengths.length; i++) {
                increment(planks, lengths[i], -possibleMatches * counts[i]);
            }
        }
    }

    private static void addPartialTile(long x1, long y1, long x2, long y2, Map<Integer, Long> requiredLengths) {

        if (x1 == x2 || y1 == y2) return;

        boolean horizontal = (x1 % 10) < 5;

        if (horizontal) {
            increment(requiredLengths, (int) (x2 - x1), y2 -y1);
        }
        else {
            increment(requiredLengths, (int) (y2 - y1), x2 - x1);
        }
    }

    private static void increment(Map<Integer, Long> map, int key, long dValue) {
        map.put(key, map.get(key) + dValue);
    }
}
