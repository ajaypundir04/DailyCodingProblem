package demo.code.dailycodingprob;

import java.util.ArrayList;
import java.util.List;

public class TotalSteps {

    static int counter = 0;
    public static void main(String[] args) {
        new TotalSteps().uniqueSteps(
                new int[]{1, 2},
//                new int[]{1, 3, 5},
                4
        );
        System.out.println(counter);
    }

    public void uniqueSteps(int[] stepsTaken, int total) {
        execute(stepsTaken, total, new ArrayList<>());
    }

    private void execute(int[] s, int total, List<Integer> a) {
        counter++;
        int sum = a.stream().mapToInt(Integer::intValue).sum();
        if (sum > total) {
            return;
        }
        if (sum == total) {
            System.out.println(a);
            return;
        }

        for (int i = 0; i < s.length; i++) {
            List<Integer> n = new ArrayList<>(a);
            n.add(s[i]);
            execute(s, total, n);
        }
    }
}
