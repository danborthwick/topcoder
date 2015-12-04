
public class AutoAdjust {

    public static final float BLACK = 32;
    public static final float GREY = 63.5f;
    public static final float WHITE = 95;

    public static String[] adjust(String[] input)
    {
        float minPixel = Float.MAX_VALUE;
        float maxPixel = 0;

        for (String row : input) {
            for (float pixel : row.getBytes()) {
                minPixel = Math.min(minPixel, pixel);
                maxPixel = Math.max(maxPixel, pixel);
            }
        }

        float brightness = GREY - ((maxPixel + minPixel) / 2f);
        float contrast = (WHITE - BLACK) / (maxPixel - minPixel);

        String[] output = new String[input.length];

        for (int row = 0; row < input.length; row++) {
            byte[] inputPixels = input[row].getBytes();
            char[] outputPixels = new char[inputPixels.length];
            for (int col=0; col < inputPixels.length; col++) {
                outputPixels[col] = adjustPixel(inputPixels[col], brightness, contrast);
            }

            output[row] = new String(outputPixels);
        }

        return output;
    }

    private static char adjustPixel(byte inputPixel, float brightness, float contrast) {
        return (char) (Math.round(((float) inputPixel + brightness - GREY) * contrast) + GREY);
    }
}
