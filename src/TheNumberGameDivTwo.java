import java.util.ArrayList;
import java.util.List;

public class TheNumberGameDivTwo {

    enum Outcome {
        Unknown,
        Win,
        Lose,
    }

    private List<List<Integer>> factors;
    private List<Outcome> outcomes;

    private List<Outcome> initialiseOutcomes(int c) {
        List<Outcome> result = new ArrayList<>(c + 1);
        for (int i=0; i <= c; i++) {
            result.add(Outcome.Unknown);
        }
        return result;
    }

    private List<List<Integer>> initialiseFactors(int c) {
        List<List<Integer>> factors = new ArrayList(c + 1);

        for (int i=0; i <= c; i++) {
            factors.add(new ArrayList<>());
        }

        return factors;
    }

    private void findFactors() {
        // Prime = lose. Start with all primes then sieve of Eratosthenes to mark
        // non-primes as unknown
        int max = (int) Math.ceil(Math.sqrt(factors.size()));
        int p = 2;
        while (p <= max) {
            for (int i = p + p; i < factors.size(); i += p) {
                List<Integer> existingFactors = factors.get(i);
                if (!existingFactors.contains(p)) {
                    existingFactors.add(p);
                }
            }

            // Find next prime
            for (p++; p < factors.size() && !isPrime(p); p++);
        }
    }

    private void findOutcomes() {
        for (int c = 1; c < outcomes.size(); c++) {
            Outcome result = Outcome.Lose;

            for (Integer factor : factors.get(c)) {
                if (outcomes.get(c - factor) == Outcome.Lose) {
                    result = Outcome.Win;
                    break;
                }
            }

            outcomes.set(c, result);
        }
    }

    private boolean isPrime(int p) {
        return factors.get(p).size() == 0;
    }

    private String result(int c) {
        factors = initialiseFactors(c);
        outcomes = initialiseOutcomes(c);

        findFactors();
        findOutcomes();

        switch (outcomes.get(outcomes.size() - 1)) {
            case Win:
                return "John";
            case Lose:
                return "Brus";
            default:
                return "Unknown";
        }
    }

    public static String find(int c) {
        return new TheNumberGameDivTwo().result(c);
    }
}
