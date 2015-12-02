public class BadClock {

    public static final double SECONDS_PER_TWELVE_HOURS = 12 * 60 * 60;

    static double nextAgreement(String trueTime, String skewTime, int hourlyGain)
    {
        double trueSeconds = secondsFromString(trueTime);
        double skewSeconds = secondsFromString(skewTime);
        double difference = trueSeconds - skewSeconds;
        double hours = 0;

        while (Math.abs(difference / hourlyGain) > 12)
        {
            trueSeconds += SECONDS_PER_TWELVE_HOURS;
            skewSeconds += SECONDS_PER_TWELVE_HOURS + (hourlyGain * 12.0);
            difference = (trueSeconds - skewSeconds) % SECONDS_PER_TWELVE_HOURS;
            hours += 12.0;
        }

        return hours + (difference / hourlyGain);
    }

    private static double secondsFromString(String s) {
        double hours = parseIntFromSubString(s, 0, 2);
        double minutes = parseIntFromSubString(s, 3, 5);
        double seconds = parseIntFromSubString(s, 6, 8);
        return (((hours * 60) + minutes) * 60) + seconds;
    }

    private static int parseIntFromSubString(String s, int beginIndex, int endIndex) {
        return Integer.parseInt(s.substring(beginIndex, endIndex));
    }
}
