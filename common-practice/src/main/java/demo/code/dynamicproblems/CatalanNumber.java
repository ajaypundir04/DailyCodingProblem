package demo.code.dynamicproblems;

import java.util.Arrays;

public class CatalanNumber {

    static int counter = 0;

    static int[] cat;

    public int catalan(int n) {
        counter++;
        if (cat[n] != 0) {
            return cat[n];
        }
        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        cat[n] = res;
        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        cat = new int[n + 1];
        System.out.println(
                new CatalanNumber().catalan(n)
        );
        System.out.println(Arrays.toString(cat));
        System.out.println("Method calls \"" + counter + "\" times.");
    }
}
