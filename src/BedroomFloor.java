import java.util.HashMap;
import java.util.Map;

public class BedroomFloor {
    public static long numberOfSticks(int x1, int y1, int x2, int y2) {

        Map<Integer, Long> requiredLengths = new HashMap();
        for (int i=1; i<=5; i++)
            requiredLengths.put(i, 0L);

        int xWholeStart = (int) (Math.ceil(x1 / 5.0) * 5.0);
        int yWholeStart = (int) (Math.ceil(y1 / 5.0) * 5.0);
        int xWholeEnd = (int) (Math.floor(x2 / 5.0) * 5.0);
        int yWholeEnd = (int) (Math.floor(y2 / 5.0) * 5.0);

        // Top Left
        addPartialTile(x1, y1, xWholeStart, yWholeStart, requiredLengths);
        // Top right
        addPartialTile(xWholeEnd, y1, x2, yWholeStart, requiredLengths);
        // Bottom left
        addPartialTile(x1, yWholeEnd, xWholeStart, y2, requiredLengths);
        // Bottom right
        addPartialTile(xWholeEnd, yWholeEnd, x2, y2, requiredLengths);

        // Top, bottom sides
        for (int x = xWholeStart; x < xWholeEnd; x += 5) {
            addPartialTile(x, y1, x + 5, yWholeStart, requiredLengths);
            addPartialTile(x, yWholeEnd, x + 5, y2, requiredLengths);
        }
        // Left, right sides
        for (int y = yWholeStart; y < yWholeEnd; y += 5) {
            addPartialTile(x1, y, xWholeStart, y + 5, requiredLengths);
            addPartialTile(xWholeEnd, y, x2, y + 5, requiredLengths);
        }
        // Whole panels
        int numPanels = (xWholeEnd - xWholeStart) * (yWholeEnd - yWholeStart) / 5;
        int numFullSticks = numPanels * 5;
        increment(requiredLengths, 5, numFullSticks);

        return requiredLengths.get(5);
    }

    private static void addPartialTile(int x1, int y1, int x2, int y2, Map<Integer, Long> requiredLengths) {

        if (x1 == x2 || y1 == y2) return;

        boolean horizontal = (x1 % 10) < 5;

        if (horizontal) {
            increment(requiredLengths, x2 - x1, (long) (y2 -y1));
        }
        else {
            increment(requiredLengths, y2 - y1, (long) (x2 - x1));
        }
    }

    private static void increment(Map<Integer, Long> map, int key, long dValue) {
        map.put(key, map.get(key) + dValue);
    }
}
