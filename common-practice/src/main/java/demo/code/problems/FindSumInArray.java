package demo.code.problems;

import java.util.Arrays;

public class FindSumInArray {

    public static void main(String[] args) {
        FindSumInArray a = new FindSumInArray();
        System.out.println(Arrays.toString(a.twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] tmpArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int tmpSum = nums[i] + nums[j];
            if (tmpSum == target) {
                result[0] = indexOf(tmpArray, nums[i], -1);
                result[1] = indexOf(tmpArray, nums[j], result[0]);
                break;
            }
            if (tmpSum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    private int indexOf(int[] arr, int e, int visited) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e && i != visited) {
                index = i;
                break;
            }
        }
        return index;
    }
}
