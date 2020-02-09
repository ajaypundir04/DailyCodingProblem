package demo.code.practicegfg;

import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static void main (String[] args) {
        //code
//        Scanner sc = new Scanner(System.in);
//
//        int tests = sc.nextInt();
//        for(int i = 0; i < tests; i ++) {
//            int e = sc.nextInt();
//            int []arr = new int[e];
//            int sum = sc.nextInt();
//
//            for( int j=0; j < e; j++) {
//                arr[j] = sc.nextInt();
//            }
            printPositions(new int[] {1, 2, 4, 5}, 4, 4);
//        }
    }

    static void printPositions(int []arr, int l, int sum) {

        int s = 0;
        int start,end;
        boolean found = false;
        for(int i =0 ; i <l; i++) {
            s = 0;
            if(arr[i] > sum) {
                continue;
            }
            for (int j = i; j < l; j++) {
                s+= arr[j];
                if(sum == s) {
                    end = j;
                    found = true;
                    System.out.println((i + 1)+" "+(j+1));
                    break;
                } else if ( s > sum) {
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        if(!found) {
            System.out.println(-1);
        }
    }
}
