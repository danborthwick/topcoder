public class AgeEncoding {
    static final double threshold = 1E-10;

    public static double getRadix(int age, String candlesLine) {
        if (oneCount(candlesLine) == 1) {
            boolean lsbIsOne = candlesLine.charAt(candlesLine.length() - 1) == '1';
            if (age == 1 && lsbIsOne)
                return -2.0;
            else if (age == 1)
                return 1.0;
            else if (lsbIsOne)
                return -1;
        }

        double lower = 0.0;
        double upper = age;
        double mid = upper - lower / 2.0;

        while (upper - lower > threshold)
        {
            mid = (upper + lower) / 2.0;
            double midAge = getAge(mid, candlesLine);

            if (midAge < age)
                lower = mid;
            else
                upper = mid;
        }

        return mid;
    }

    private static double getAge(double base, String candlesLine) {
        double age = 0.0;

        for (int d=0; d < candlesLine.length(); d++) {
            if (candlesLine.charAt(candlesLine.length() - d - 1) == '1')
                age += Math.pow(base, d);
        }

        return age;
    }

    private static int oneCount(String candlesLine) {
        int count = 0;

        for (int i = 0; i < candlesLine.length(); i++)
            if (candlesLine.charAt(i) == '1')
                count++;

        return count;
    }
}
