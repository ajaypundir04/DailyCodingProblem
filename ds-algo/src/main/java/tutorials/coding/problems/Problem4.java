package tutorials.coding.problems;

import java.util.Arrays;

/**
 * Missing Lowest Positive Integer
 * <p>
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input `[3, 4, -1, 1]` should give `2`. The input `[1, 2, 0]` should give `3`
 */
public class Problem4 {

    public int bruteForceSolution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1], min, sum = arr[arr.length - 1];

        //Mark -ve and duplicate as 0.
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0 || arr[i] == arr[i + 1]) {
                arr[i] = 0;
            }
            sum += arr[i];
        }

        if (max < arr.length) {
            return arr.length;
        } else {
            min = (max - arr.length) + 1;
        }

        int expectedSum = (int)((arr.length / 2.0) * (2 * min + (arr.length - 1)));
        return expectedSum - sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new Problem4().bruteForceSolution(new int[]{5, 7, -1, 8, 9})
        );
    }
}
