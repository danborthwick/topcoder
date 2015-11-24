public class PrimeNumberRange {
    public static void main(String[] args) {
        long starting_number = 1000000L;
        long ending_number = 2000000L;
        long totals = 0;

        System.out.println("List of prime numbers between " + starting_number + " and " + ending_number);

        for (long current = starting_number; current <= ending_number; current++) {
            long sqr_root = (long) Math.sqrt(current);
            boolean is_prime = true;
            for (long i = 2; i <= sqr_root; i++) {
                if (current % i == 0) {
                    is_prime = false; // Current is not prime.
                }
            }
            if (is_prime) {
                System.out.println(current);
                totals++;
            }
        }
        System.out.println("There are a total of "+totals+" prime numbers between "+starting_number+" and "+ending_number);
    }
}
