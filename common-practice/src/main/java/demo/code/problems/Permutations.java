package demo.code.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3});
    }

    public void permute(int[] nums) {
        int[] result = new int[nums.length];
        int[] tracker = new int[nums.length];
        start1(nums, tracker, result, 0).forEach(System.out::println);
    }

    private List<List<Integer>> start1(int[] nums, int[] tracker, int[] result, int visited) {

        List<List<Integer>> r = new ArrayList<>();
        if (nums.length == visited) {
            r.add(Arrays.stream(result.clone()).boxed().collect(Collectors.toList()));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tracker[i] == 0) {
                    result[visited] = nums[i];
                    tracker[i] = 1;
                    r.addAll(start1(nums, tracker, result, visited + 1));
                    tracker[i] = 0;
                }
            }
        }
        return r;
    }

//    private void start(int[] nums, int k) {
//
//        if (nums.length == k) {
//            System.out.println(Arrays.toString(result));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (tracker[i] == 0) {
//                    result[i] = nums[i];
//                    tracker[i] = 1;
//                    start(nums, k + 1);
//                    tracker[i] = 0;
//                }
//            }
//        }
//    }
}
