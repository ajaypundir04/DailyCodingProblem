package tutorials.coding.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 */
public class Problem1 {

    public boolean findSumUsingAuxiliarySpace(int[] array, int sum) {
        Set<Integer> tmp = new HashSet<>();

        for (int i : array) {
            if (tmp.contains(sum - i)) {
                return true;
            } else {
                tmp.add(i);
            }
        }
        return false;
    }

    // TODO: update the code.
    public boolean findSumRecursively(int[] array, int sum) {
        return recursiveAlgo(array, 0, sum);
    }

    private boolean recursiveAlgo(int[] array, int start, int sum) {
        if (start >= array.length) {
            return false;
        }

        if (array[start] == sum) {
            return true;
        } else if (sum < array[start]) {
            return recursiveAlgo(array, start + 1, sum);
        } else {
            return recursiveAlgo(array, start + 1, sum - array[start])
                    || recursiveAlgo(array, start + 1, sum);
        }
    }
}
