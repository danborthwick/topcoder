import java.util.Arrays;

public class TheNumberGameDivTwo {

    enum Outcome {
        Unknown,
        Win,
        Lose,
    };

    private final Outcome[] outcomes;

    public TheNumberGameDivTwo(int c) {
        outcomes = new Outcome[c];

        markPrimesAsLose();
    }

    private void markPrimesAsLose() {
        // Prime = lose. Start with all primes then sieve of Eratosthenes to mark
        // non-primes as unknown
        Arrays.fill(outcomes, Outcome.Lose);
        int max = (int) Math.ceil(Math.sqrt(outcomes.length));
        int p = 2;
        while (p < max) {
            for (int i = p; i < outcomes.length; i += p) {
                outcomes[i] = Outcome.Unknown;
            }

            // Find next unmarked p
            for (; p < outcomes.length && (outcomes[p] != Outcome.Lose); p++);
        }
    }

    private String result() {
        return null;
    }

    public static String find(int c) {
        TheNumberGameDivTwo game = new TheNumberGameDivTwo(c);
        return game.result();
    }
}
