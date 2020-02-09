package demo.code.dailycodingprob;

public class TotalStepsSolution {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println(
                staircase(
                        new int[]{1, 3, 5},
                        4
                )
        );

        System.out.println(
                dp(
                        new int[]{1, 3,5},
                        4
                )
        );
        System.out.println(counter);
    }

    static int staircase(int[] x, int n) {
        counter++;
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i : x) {
            sum += staircase(x, n - i);
        }
        return sum;
    }

    static int dp(int[] x, int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 0; j < x.length; j++) {
                if ((i - x[j]) >= 0) {
                    sum += cache[i - x[j]];
                }
            }
            cache[i] += sum;
        }
        return cache[n];
    }
}
