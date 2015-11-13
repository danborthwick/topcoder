public class ANDEquation {

    public static int restoreY(int[] A)
    {
        int min = A[0];
        int minIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < min)
            {
                minIndex = i;
                min = A[i];
            }
        }

        int result = Integer.MAX_VALUE;

        for (int j=0; j < A.length; j++)
        {
            if (minIndex == j) continue;

            result &= A[j];
        }

        return (result == min) ? min : -1;
    }
}
