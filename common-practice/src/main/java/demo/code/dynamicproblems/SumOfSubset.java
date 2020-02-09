package demo.code.dynamicproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfSubset {

    public static void main(String[] args) {
        int sum = 16;
        System.out.println("Total pairs with sum " + sum + " are: " +
                        subsetsWithSum(
//                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                                new int[]{2, 4, 6, 10},
                                sum
                        )
        );
        System.out.println(counter);
    }

    static int counter = 0;

    static int subsetsWithSum(int[] a, int sum) {
//        return findAll(a, 0, new HashSet<>(), sum);
        return findAll(a, sum, a.length - 1, new HashMap<>());
    }

    static int findAll(int[] a, int sum, int i, Map<String, Integer> cache) {
        String k = key(sum, i);
        if (cache.containsKey(k)) {
            return cache.get(k);
        }
        counter++;
        if (sum == 0) {
            return 1;
        }

        if (sum < 0 || i < 0) {
            return 0;
        }

        int r = 0;
        if (sum < a[i]) {
            r = findAll(a, sum, i - 1, cache);
        } else {
            r = findAll(a, sum - a[i], i - 1, cache) + findAll(a, sum, i - 1, cache);
        }
        cache.put(k, r);
        return r;
    }

    static int findAll(int[] a, int start, Set<Integer> s, int sum) {
        counter++;
        int count = 0;
        int tmpSum = s.stream().mapToInt(Integer::intValue).sum();
        if (tmpSum == sum) {
            System.out.println(s);
            return 1;
        }

        if (tmpSum > sum) {
            return 0;
        }

        for (int i = start; i < a.length; i++) {
            s.add(a[i]);
            count += findAll(a, i + 1, s, sum);
            s.remove(a[i]);
        }

        return count;
    }

    private static String key(int sum, int i) {
        return sum + ":" + i;
    }
}
