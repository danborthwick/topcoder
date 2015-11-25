public class BSTConstruction {
    public static long sumHeights(int n, int seed, int limit) {

        long[] p = makePerms(n, seed, limit);

        Node root = makeTree(p);

        return root.addHeights(1);
    }

    private static Node makeTree(long[] p) {
        Node root = new Node(p[0]);
        for (int i=1; i < p.length; i++)
            root.insert(p[i]);
        return root;
    }

    private static long[] makePerms(int n, int seed, int limit) {
        long[] p = new long[n];

        long X = seed;

        for (int i=0; i < n; i++)
        {
            p[i] = i;
            X = (X * 295397169L) % 1073741789L;
            if ((X * 1000000L) / 1073741789L < limit) {
                X = (X * 295397169L) % 1073741789L;
                // generate j within [0, i]
                int j = (int) ((X * (i + 1L)) / 1073741789L);
                // j <= i, so p[j] is already initialized
                long temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
        return p;
    }

    static class Node
    {
        public long value;
        public Node left = null;
        public Node right = null;

        public Node(long value) {
            this.value = value;
        }

        public void insert(long x)
        {
            if (x < value)
            {
                if (left != null)
                    left.insert(x);
                else
                    left = new Node(x);
            }
            else
            {
                if (right != null)
                    right.insert(x);
                else
                    right = new Node(x);
            }
        }

        public long addHeights(long depth) {
            long result = depth;

            if (left != null)
                result += left.addHeights(depth + 1);

            if (right != null)
                result += right.addHeights(depth + 1);

            return result;
        }
    }
}
