package demo.code.problems;

import java.util.Arrays;

public class Problem2 implements Runnable {
    @Override
    public void run() {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int[] result = Arrays.stream(nums).sorted()
                .distinct().toArray();
        return result[result.length - k];

    }
}
