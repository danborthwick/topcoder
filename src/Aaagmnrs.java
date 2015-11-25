import java.util.*;

public class Aaagmnrs
{
    public static String[] anagrams(String[] input)
    {
        ArrayList<String> result = new ArrayList<>();

        for (int i=0; i < input.length; i++)
        {
            for (int j=i + 1; j < input.length; j++)
            {
                    boolean skip = false;
                for (String knownResult : result) {
                    if (isAnagram(clean(knownResult), clean(input[i]))) {
                        skip = true;
                        break;
                    }
                }

                if (skip)
                    break;

                if (isAnagram(clean(input[i]), clean(input[j]))) {
                    result.add(input[i]);
                    break;
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private static String clean(String s)
    {
        return s.toLowerCase().replaceAll(" +", "");
    }

    private static boolean isAnagram(String in, String out)
    {
        Map<Character, Integer> inHist = hist(in);
        Map<Character, Integer> outHist = hist(out);
        return inHist.equals(outHist);
    }

    private static Map<Character,Integer> hist(String in)
    {
        Map<Character, Integer> result = new HashMap<>();
        for (int i=0; i < in.length(); i++)
        {
            char c = in.charAt(i);
            if (!result.containsKey(c))
            {
                result.put(c, 1);
            }
            else
            {
                result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }
}
