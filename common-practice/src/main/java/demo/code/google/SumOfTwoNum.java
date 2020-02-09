package demo.code.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNum {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(nums(new int[] {10, 15, 3, 7}, 17))
        );

        System.out.println(
                Arrays.toString(usingSorted(new int[] {10, 15, 3, 7}, 17))
        );
    }

    static int[] nums(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            int ans = sum - a;
            if (set.contains(ans)) {
                return new int[]{ans, a};
            } else {
                set.add(a);
            }
        }
        return new int[0];
    }

    static int[] usingSorted(int[] arr, int sum) {
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1; i < j; ) {
            int tmp = arr[i] + arr[j];
            if(tmp == sum) {
                return new int[] {arr[i], arr[j]};
            } else if(tmp < sum) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }
}
