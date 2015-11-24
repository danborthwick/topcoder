import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TwoCities {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();

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
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        System.out.println(maxWord + " " + max + " times");

        //Close the input stream
        br.close();

    }
    }
