public class ANDEquation {

    public static int restoreY(int[] A)
    {
        for (int i=0; i < A.length; i++)
        {
            int result = Integer.MAX_VALUE;

            for (int j=0; j < A.length; j++)
            {
                if (i == j) continue;

                result &= A[j];
            }

            if (result == A[i]) return A[i];
        }

        return -1;
    }
}
