package demo.code.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        int[][]ar = new int[][] {
//                {2,3},{4,5},{6,7},{8,9},{1,10}
//        };
        int[][]ar = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };
        System.out.println(Arrays.toString(merge(ar)));
    }

    public static int[][] merge(int[][] intervals) {
        int []cache = new int[200];

        for(int i = 0 ; i < intervals.length; i++) {
            int[] arr = intervals[i];
            cache[arr[0]] = i + 1;
            cache[arr[1]] = i + 1;
        }

        ;
        int lastNumber = -1;
        int lastIndex = -1;
        List<int[]> result = new ArrayList<>();
        for(int i = 0 ; i < cache.length; i++) {
            if(cache[i] != 0) {
                if(lastNumber == -1){
                    lastNumber = cache[i];
                    lastIndex = i;
                }
            } else if(cache[i] == lastNumber) {
                result.add(new int[]{lastIndex, i});
                lastIndex = lastNumber = -1;
            }
        }
        int[][] ar = new int[result.size()][];
        for(int i = 0 ; i < result.size(); i++) {
            ar[i] = result.get(i);
        }
        return ar;
    }
}
