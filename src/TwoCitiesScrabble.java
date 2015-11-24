import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TwoCitiesScrabble {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        
        final Object[][] scoresData = {
                {"A", 1},
                {"B", 3},
                        {"C", 3 },
                                {"D", 2},
                                        {"E", 1},
                                                {"F", 4 },
                {"G", 2},
                {"H", 4},
                {"I", 1},
                {"J", 8},
                {"K", 5},
                {"L", 1},
                {"M", 3},
                {"N", 1},
                {"O", 1},
                {"P", 3},
                {"Q", 10},
                {"R",1},
                {"S",1},
                {"T",1},
                {"U",1},
                {"V",4},
                {"W",4},
                {"X",8},
                {"Y",4},
                {"Z",10}
        };

        Map<Character, Integer> scores = new HashMap<>();
        for (Object[] objects : scoresData) {
            String s = (String) objects[0];
            int i = (Integer) objects[1];
            scores.put(s.charAt(0), i);
        }


        FileInputStream fstream = new FileInputStream("twocities.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            for (String s : strLine.split(" ")) {
                Integer current = map.get(s);
                map.put(s, (current != null) ? current + 1 : 1);
            }
        }



        int max = 0;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = 0;
            String word = entry.getKey().toUpperCase();
            for (int i=0; i < word.length(); i++) {
                char c = word.charAt(i);
                Integer integer = scores.get(c);
                if (integer == null) break;
                score += integer;
            }
            if (score > max)
            {
                max = score;
                maxWord = word;
            }
        }
        System.out.println(maxWord + " " + max + " times");

        //Close the input stream
        br.close();

    }
    }
