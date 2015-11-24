import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
    public static String decode(String a, String b, String y) {
        Map<Character, Character> table = new HashMap<Character, Character>();

        for (int i=0; i < a.length(); i++)
        {
            table.put(b.charAt(i), a.charAt(i));
        }

        if (table.size() == 25)
        {
            for (char c = 'A'; c <= 'Z'; c++)
            {
                if (!table.containsKey(c))
                {
                    for (char d = 'A'; d <= 'Z'; d++)
                    {
                        if (!table.values().contains(d))
                        {
                            table.put(c, d);
                        }
                    }

                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i < y.length(); i++)
        {

            Character out = table.get(y.charAt(i));

            if (out == null) return "";

            result.append(out);
        }

        return result.toString();
    }
}
