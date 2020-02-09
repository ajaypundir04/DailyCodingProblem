package demo.code.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TrappedWaterDemo {

    public static void main(String[] args) {

        Stream.of(
//                new int[]{7, 4, 0, 9},
//                new int[]{6, 9, 9},
                new int[]{0,1,0,2,1,0,1,3,2,1,2,1}
        )
                .map(TrappedWaterDemo::trappedWater)
                .forEach(System.out::println);
    }

    static int trappedWater(int[] arr) {
        int[] lMaxArray = new int[arr.length];
        int[] rMaxArray = new int[arr.length];
        int last = arr.length - 1;

        int lMax = 0, rMax = 0;

        for (int i = 0; i <= last; i++) {
            if (lMax < arr[i]) {
                lMax = arr[i];
            }

            if (rMax < arr[last - i]) {
                rMax = arr[last - i];
            }

            lMaxArray[i] = lMax;
            rMaxArray[last - i] = rMax;
        }
        int total = 0;
        for (int i = 0; i <= last; i++) {
            total += Integer.min(lMaxArray[i], rMaxArray[i]) - arr[i];
        }


        return total;
    }

    private int[][] toArray(List<int[]> ar) {
        int [][]a = new int[ar.size()][];
        for(int i = 0 ; i < ar.size(); i++) {
            a[i] = ar.get(i);
        }
        return a;
    }
}
