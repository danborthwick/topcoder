public class LengthUnitCalculator {

    static final String[] units = new String[] { "in", "ft", "yd", "mi" };
    static final double[] multipliers = new double[] { 12, 3, 1760 };

    public static double calc(int amount, String fromUnit, String toUnit) {
        int fromId = unitIndex(fromUnit);
        int toId = unitIndex(toUnit);
        double result = amount;

        while (fromId < toId) {
            result /= multipliers[fromId];
            fromId++;
        }

        while (fromId > toId) {
            fromId--;
            result *= multipliers[fromId];
        }

        return result;
    }

    private static int unitIndex(String unit) {
        for (int i=0; i < units.length; i++) {
            if (units[i].equals(unit)) {
                return i;
            }
        }

        return -1;
    }
}
