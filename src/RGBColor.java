public class RGBColor {
    public static int[] getComplement(int[] input) {
        int[] output = new int[] {
                255 - input[0], 255 - input[1], 255 - input[2]
        };

        if (isGrey(input, output)) {
            output[0] = greyComplement(input[0]);
            output[1] = greyComplement(input[1]);
            output[2] = greyComplement(input[2]);
        }

        return output;
    }

    private static int greyComplement(int input) {
        return ((input - 128) + 256) % 256;
    }

    private static boolean isGrey(int[] input, int[] output) {
        boolean result = true;
        for (int i=0; i<3; i++) {
            result &= Math.abs(input[i] - output[i]) <= 32;
        }
        return result;
    }
}
