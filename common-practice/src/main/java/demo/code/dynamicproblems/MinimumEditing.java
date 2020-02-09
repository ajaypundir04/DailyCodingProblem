package demo.code.dynamicproblems;

public class MinimumEditing {

    public static void main(String[] args) {
        MinimumEditing e = new MinimumEditing();

//        System.out.println(e.minDistance("horse", "ros"));
        System.out.println(e.minDistance(
                "dinitrophenylhydrazine",
                "benzalphenylhydrazone"
        ));
    }

    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        return minDistance(word1.toCharArray(), word2.toCharArray(), word1.length(), word2.length(), cache);
    }

    private int minDistance(char[] w1, char[] w2, int m, int n, int[][] cache) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if(cache[m - 1][n - 1] > 0) {
            return cache[m - 1][n - 1];
        }

        if (w1[m - 1] == w2[n - 1]) {
            return minDistance(w1, w2, m - 1, n - 1, cache);
        } else {
            int insert = minDistance(w1, w2, m - 1, n, cache);
            int remove = minDistance(w1, w2, m , n - 1, cache);
            int replace = minDistance(w1, w2, m - 1, n - 1, cache);

            int min = Math.min(insert, Math.min(remove, replace));
            int value = 1 + min;
            cache[m - 1][n - 1] = value;
            return value;
        }
    }
}
