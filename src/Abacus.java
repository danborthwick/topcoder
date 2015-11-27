public class Abacus {
    public static String[] add(String[] input, int val) {

        int inputInt = 0;
        for (int d = 0; d < 6; d++)
        {
            String thread = input[d];
            String[] split = thread.split("---");
            int digit = split.length == 2 ? split[1].length() : 0;

            inputInt += digit * Math.pow(10, 5 - d);
        }

        int outputInt = inputInt + val;

        String[] result = new String[6];

        for (int d = 0; d < 6; d++)
        {
            int dec = (int) Math.pow(10, 5 - d);
            int digit = outputInt / dec;


            char[] thread = new char[12];
            int firstDash = 12 - digit - 3;
            for (int t = 0; t < 12; t++)
            {
                thread[t] = (t >= firstDash) && (t < firstDash + 3) ? '-' : 'o';
            }

            outputInt -= digit * dec;

            result[d] = new String(thread);
        }


        return result;
    }
}
