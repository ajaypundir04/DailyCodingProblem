package demo.code.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfThreeNums {

    static int counter = 0;

    public static void main(String[] args) {
//        List<List<Integer>> result = threeSum(new int[]{0, 0, 0, 0});
//        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 0});
//        List<List<Integer>> result = threeSum(new int[]{-2, 0, 1, 1, 2});
//        List<List<Integer>> result = threeSum(new int[]{3,-2,1,0});
//        List<List<Integer>> result = threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
//        List<List<Integer>> result = threeSum(new int[]{-4,-8,7,13,10,1,-14,-13,0,8,6,-13,-5,-4,-12,2,-11,7,-5,0,-9,-14,-8,-9,2,-7,-13,-3,13,9,-14,-6,8,1,14,-5,-13,8,-10,-5,1,11,-11,3,14,-8,-10,-12,6,-8,-5,13,-15,2,11,-5,10,6,-1,1,0,0,2,-7,8,-6,3,3,-13,8,5,-5,-3,9,5,-4,-14,11,-8,7,10,-6,-3,11,12,-14,-9,-1,7,5,-15,14,12,-5,-8,-2,4,2,-14,-2,-12,6,8,0,0,-2,3,-7,-14,2,7,12,12,12,0,9,13,-2,-15,-3,10,-14,-4,7,-12,3,-10});
//        result.forEach(arr -> System.out.println(arr.toString()));
        comboDemo();
    }

    private static void comboDemo() {
//        int[] arr = new int[]{-4,-8,7,13,10,1,-14,-13,0,8,6,-13,-5,-4,-12,2,-11,7,-5,0,-9,-14,-8,-9,2,-7,-13,-3,13,9,-14,-6,8,1,14,-5,-13,8,-10,-5,1,11,-11,3,14,-8,-10,-12,6,-8,-5,13,-15,2,11,-5,10,6,-1,1,0,0,2,-7,8,-6,3,3,-13,8,5,-5,-3,9,5,-4,-14,11,-8,7,10,-6,-3,11,12,-14,-9,-1,7,5,-15,14,12,-5,-8,-2,4,2,-14,-2,-12,6,8,0,0,-2,3,-7,-14,2,7,12,12,12,0,9,13,-2,-15,-3,10,-14,-4,7,-12,3,-10};
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int r = 3;
        int[] data = new int[r];
        int start = 0, index = 0, end = arr.length;
//        List<int[]> combos = combinations1(arr, data, start, end, index, r);
        List<int[]> combos = comboUsingDFS(arr, data, start, end, r);
//        List<int[]> combos = combinationsUsingLoop(arr, r);
        combos.forEach(ar -> System.out.println(Arrays.toString(ar)));
        System.out.println(counter);
    }

    private static List<int[]> combinationsUsingLoop(int[] nums, int r) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int[] arr = new int[3];
            arr[0] = nums[i];
            for (int j = i; j < nums.length - 1; j++) {
                arr[1] = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    arr[2] = nums[k];
                    result.add(arr.clone());
                }
            }
        }
        return result;
    }

    private static List<int[]> combinations(int[] nums, int[] data, int start, int end, int index, int r) {
        ++counter;
        System.out.println(Arrays.toString(nums) + "  -  " + Arrays.toString(data) + "  -  " + start + "  -  " + end + "  -  " + index + "  -  " + r);
        List<int[]> result = new ArrayList<>();

        if (index == r) {
            result.add(data.clone());
        } else {
            for (int i = start; i < end; i++) {
                data[index] = nums[i];
                result.addAll(
                        combinations(nums, data, i + 1, end, index + 1, r)
                );
            }
        }
        return result;
    }

    private static List<int[]> comboUsingDFS(int[] nums, int[] data, int start, int end, int r) {
        ++counter;
        List<int[]> result = new ArrayList<>();

        if (r == 0) {
            result.add(data.clone());
        } else {
            for (int i = start; i < end; i++) {
                data[3 - r] = nums[i];
                result.addAll(comboUsingDFS(nums, data, start + 1, end, r - 1));
                data[3 - r] = 0;
            }
        }
        return result;
    }

    private static List<int[]> combinations1(int[] nums, int[] data, int start, int end, int index, int r) {
        ++counter;
        System.out.println(Arrays.toString(nums) + "  -  " + Arrays.toString(data) + "  -  " + start + "  -  " + end + "  -  " + index + "  -  " + r);
        List<int[]> result = new ArrayList<>();

        if (index == r) {
            result.add(data.clone());
        } else if (start >= end) {
            return Collections.emptyList();
        } else {
            data[index] = nums[start];
            result.addAll(combinations(nums, data, start + 1, end, index + 1, r));
            result.addAll(combinations(nums, data, start + 1, end, index, r));
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<int[]> combos = combinations(nums, new int[3], 0, nums.length, 0, 3);
        return combos.stream()
                .filter(SumOfThreeNums::isSumZero)
                .map(SumOfThreeNums::toSortedArray)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Integer> toSortedArray(int[] nums) {
        List<Integer> list = Arrays.asList(nums[0], nums[1], nums[2]);
        Collections.sort(list);
        return list;
    }

    private static boolean isSumZero(int[] arr) {
        return Arrays.stream(arr).sum() == 0;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return Collections.emptyList();
//        }
//
//        List<List<Integer>> tripelts = new ArrayList<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                int sum = nums[i] + nums[i + 1] + nums[j];
//                if (i != j && (i + 1) != j && sum == 0) {
//                    List<Integer> result = Arrays.asList(nums[i], nums[i + 1], nums[j]);
//                    Collections.sort(result);
//                    tripelts.add(result);
//                }
//            }
//        }
//
//        return tripelts.stream().distinct().collect(Collectors.toList());
//    }
}
