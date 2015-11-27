public class Archimedes {
    public static double approximatePi(int numSides) {
        double halfTheta = Math.PI / (double) numSides;
        return numSides * Math.sin(halfTheta);
    }
}
