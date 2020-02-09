package demo.code.leetcode;

import java.util.Arrays;

public class ArrayForm {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr = new int[]{3,2,1};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void transform(int[] arr) {
        int multi = 1;
        for (int i : arr) {
            multi *= i;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = div(multi, arr[i]);
        }
    }

    private static int div(int x, int y) {
        int count = 0;
        for (; x >= y; x -= y, count++) ;
        return count;
    }
}
