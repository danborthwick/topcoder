import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement
 * Elly and Kristina play a game called "Bulls". Initially each of them thinks of a non-negative integer with K digits, possibly containing leading zeroes. Then they take alternating turns, trying to guess the opponent's number. After each guess, the other person says how many positions were guessed correctly. For example if Kristina's number was "1337" and Elly's guess was "1738", Kristina should answer 2, since the digits at positions 0 and 2 (zero-based indices from the left) are correct. A guessed position is called "bull's hit", or simply a "bull", thus the name of the game.
 * <p>
 * Elly has already made several guesses. She wonders if the information she has is enough to uniquely determine Kristina's number.
 * <p>
 * You are given the guesses so far in a guesses and the corresponding number of bull's hits in bulls. If a unique number satisfies the given information, return it as a . If there is more than one number that is valid according to the current guesses, return "Ambiguity" (quotes for clarity only). If no number satisfies the given information, then Kristina has lied and you should return "Liar" instead.
 * Definition
 * Class: EllysBulls
 * Method: getNumber
 * Parameters: String[], int[]
 * Returns: String
 * Method signature: String getNumber(String[] guesses, int[] bulls)
 * (be sure your method is public)
 * Limits
 * Time limit (s): 840.000
 * Memory limit (MB): 64
 * Notes
 * - The game "Bulls" is a simplification of a game played in Bulgaria, called "Kravi & Bikove" ("Cows & Bulls").
 * Constraints
 * - guesses will contain between 1 and 50 elements, inclusive.
 * - Each element of guesses will contain between 2 and 9 characters, inclusive.
 * - All elements of guesses will contain the same number of characters.
 * - All elements of guesses will consist only of digits ('0'-'9').
 * - bulls will contain the same number of elements as guesses.
 * - Each element of bulls will be between 0 and K-1, inclusive, where K is the length of each element of guesses.
 * Examples
 * 0)
 * {"1234", "4321", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"}
 * {2, 1, 1, 0, 2, 0, 0, 0, 1, 0, 0}
 * Returns: "1337"
 * From {1234->2, 2222->0, 4444->0} it follows that the number is {1?3?}. The additional information {4321->1} tells us that either the digit at position 1 (0-indexed) is 3, or that the one at position 3 is 1. However, since {1111->1} and we already know that the 0-th digit is 1, then the third digit cannot be 1. Now we know that the number is {133?}. When trying {7777->1} we see that Kristina's number contains a 7, which cannot be anywhere else except in the last position. Thus, her number is 1337.
 * 1)
 * {"0000", "1111", "2222"}
 * {2, 2, 2}
 * Returns: "Liar"
 * There are supposed to be two 0s, two 1s and two 2s in a four-digit number. Thus, Kristina is clearly a liar.
 * 2)
 * {"666666", "666677", "777777", "999999"}
 * {2, 3, 1, 0}
 * Returns: "Ambiguity"
 * Some of the possible configurations that satisfy the current results are the numbers 636172, 336617, 660007. Thus, the answer is ambiguous.
 * 3)
 * {"000", "987", "654", "321", "100", "010"}
 * {2, 1, 0, 0, 1, 1}
 * Returns: "007"
 * The guesses, as well as the answer, can have leading zeroes.
 * 4)
 * {"28", "92", "70", "30", "67", "63", "06", "65", "11", "06", "88", "48", "09", "65", "48", "08"}
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
 * Returns: "54"
 * 5)
 * {"0294884", "1711527", "2362216", "7666148", "7295642", "4166623", "1166638", "2767693", "8650248", "2486509", "6138934", "4018642", "6236742", "2961643", "8407361", "2097376", "6575410", "6071777", "3569948", "2606380"}
 * {1, 0, 1, 3, 4, 4, 3, 2, 1, 1, 0, 4, 4, 3, 0, 0, 0, 0, 2, 1}
 * Returns: "4266642"
 */
public class EllysBulls {
    public static String getNumber(String[] guesses, int[] bulls)
    {
        boolean[][] digits = getPossibleDigits(guesses, bulls);

        String result = "";

        for (boolean[] digit : digits) {
            int candidate = -1;
            for (int digitId = 0; digitId < 10; digitId++) {
                if (digit[digitId]) {
                    if (candidate == -1) {
                        candidate = digitId;
                    } else {
                        return "Ambiguity";
                    }
                }
            }
            result += candidate;
        }

        return result;
    }

    private static boolean[][] getPossibleDigits(String[] guesses, int[] bulls) {
        int numDigits = guesses[0].length();
        boolean[][] digits = new boolean[numDigits][10];

        for (boolean[] digit : digits) {
            Arrays.fill(digit, true);
        }

        for (int guessId = 0; guessId < guesses.length; guessId++) {
            if (bulls[guessId] == 0)
            {
                String guess = guesses[guessId];
                for (int digitId = 0; digitId < numDigits; digitId++)
                {
                    int digitToClear = guess.charAt(digitId) - '0';
                    digits[digitId][digitToClear] = false;
                }
            }
        }
        return digits;
    }
}
