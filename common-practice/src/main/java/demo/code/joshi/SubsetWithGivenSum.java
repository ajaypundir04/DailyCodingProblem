package demo.code.joshi;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubsetWithGivenSum {

    public static void main(String[] args) {
        Map<int[], Integer> testData = Map.ofEntries(
                Map.entry(new int[]{2, 4, 3, 5, 6}, 7)
//                ,
//                Map.entry(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 21, 23, 42, 23, 21}, 20)
        );
        testData.forEach((k, v) -> System.out.println(findSubsetsWithSum(k, v)));
    }

    private static List<List<Integer>> findSubsetsWithSum(int[] array, int sum) {
        return findSum(array, 0, sum, new ArrayList<>());
    }

    private static List<List<Integer>> findSum(int[] arr, int i, int sum, List<Integer> ints) {
        List<List<Integer>> result = new ArrayList<>();
        if (i >= 0) {
            if (sum == 0) {
                result.add(ints);
            } else if (arr[i] == sum) {
                ints.add(arr[i]);
                result.add(ints);
            } else if (arr[i] > sum) {
                result.addAll(findSum(arr, i - 1, sum, ints));
            } else {
                for (int k = i; k < arr.length; k++) {
                    List<Integer> list = new ArrayList<>(ints);
                    list.add(arr[k]);
                    result.addAll(findSum(arr, i + 1, sum - arr[k], list));
                }
            }
        }

        return result;
    }

//    private static List<List<Integer>> findSum(int[] arr, int i, int sum, List<Integer> ints) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (i >= 0) {
//            if (sum == 0) {
//                result.add(ints);
//            } else if (arr[i] == sum) {
//                ints.add(arr[i]);
//                result.add(ints);
//            } else if (arr[i] > sum) {
//                result.addAll(findSum(arr, i - 1, sum, ints));
//            } else {
//                List<Integer> list = new ArrayList<>(ints);
//                list.add(arr[i]);
//                result.addAll(findSum(arr, i - 1, sum - arr[i], list));
//                result.addAll(findSum(arr, i, sum - arr[i], list));
//            }
//        }
//
//        return result;
//    }
}
