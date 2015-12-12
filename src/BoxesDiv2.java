import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxesDiv2 {
    public static int findSize(int[] input) {

        List<Integer> boxes = new ArrayList();
        Arrays.stream(input).map((i)->minBoxSize(i)).forEach(boxes::add);

        while (boxes.size() > 1) {
            boxes.sort(Integer::compare);
            boxes.set(0, minBoxSize(boxes.get(0) + boxes.get(1)));
            boxes.remove(1);
        }

        return boxes.get(0);
    }

    private static int minBoxSize(int min) {
        for (int i=0; i < 32; i++) {
            int boxSize = 1 << i;
            if (boxSize >= min)
                return boxSize;
        }
        return -1;
    }
}
