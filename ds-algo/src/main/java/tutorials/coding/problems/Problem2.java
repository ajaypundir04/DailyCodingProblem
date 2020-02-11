package tutorials.coding.problems;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is
 * the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]
 */
public class Problem2 {

    public int[] transform(int[] arr) {
        int multiplication = Arrays.stream(arr).reduce((l, r) -> l * r).orElse(1);
        return Arrays.stream(arr).map(i -> divide(multiplication, i)).toArray();
    }

    private int divide(int x, int y) {
        int count = 0;
        while (x >= y) {
            x = x - y;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Problem2().transform(new int[]{3, 2, 1})
                )
        );
    }
}
