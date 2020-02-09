package demo.code.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BulbsCheck {
    public static void main(String[] args) {
        System.out.println(new BulbsCheck().bulbSwitch(1));
    }

    public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        for (int i = 2; i < n; i++) {
            apply(bulbs, i);
        }
        bulbs[n - 1] = !bulbs[n - 1];
        long total = IntStream.range(0, n).mapToObj(i -> bulbs[i]).filter(v -> !v).count();
        return (int) total;
    }

    private void apply(boolean[] bulbs, int round) {
        for (int i = (round - 1); i < bulbs.length; i += round) {
            bulbs[i] = (round == 2) || !(bulbs[i]);
        }
    }
}
