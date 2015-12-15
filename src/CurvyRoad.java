import java.util.ArrayList;
import java.util.List;

public class CurvyRoad {
    public static double distance(int[] lengths, int[] radiuses) {

        double x = 0, y = 0;
        double heading = 0; // Radians above x-axis

        List<Double> lengthsCompressed = new ArrayList();
        List<Double> radiusesCompressed = new ArrayList();

        double totalLength = lengths[0];
        double lastRadius = radiuses[0];

        for (int i=1; i < lengths.length; i++) {
            if (radiuses[i] != lastRadius) {
                lengthsCompressed.add(totalLength);
                radiusesCompressed.add(lastRadius);

                totalLength = lengths[i];
                lastRadius = radiuses[i];
            }
            else {
                totalLength += lengths[i];
            }
        }
        lengthsCompressed.add(totalLength);
        radiusesCompressed.add(lastRadius);


        for (int i=0; i < lengthsCompressed.size(); i++) {

            double length = lengthsCompressed.get(i);
            double radius = radiusesCompressed.get(i);

            if (radius == 0) {
                // Straight
                x += length * Math.cos(heading);
                y += length * Math.sin(heading);
            }
            else {
                // Shift everything onto the x-axis
                double theta = Math.atan2(y, x);
                x = magnitude(x, y);
                heading -= theta;
                // y = 0

                double dHeading = length / radius;
                x -= radius - (radius * Math.cos(dHeading));
                y = Math.sin(dHeading);

                heading += dHeading;
            }
        }

        return magnitude(x, y);
    }

    private static double magnitude(double x, double y) {
        if (x == 0) {
            return Math.abs(y);
        }
        else if (y == 0) {
            return Math.abs(x);
        }
        else {
            return Math.sqrt((x * x) + (y * y));
        }
    }
}
