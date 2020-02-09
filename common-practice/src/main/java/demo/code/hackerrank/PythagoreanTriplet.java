package demo.code.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            int l = sc.nextInt();
            int[] arr = new int[l];
            for (int j = 0; j < l; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(isPythagoreanTripletExists(arr));
        }
    }

    static String isPythagoreanTripletExists(int[] arr) {
        Arrays.sort(arr);
        int[] square = Arrays.stream(arr).map(i -> i * i).toArray();
        boolean found = false;
        for (int i = square.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = square[j];
                int expected = square[i] - a;
                int index = Arrays.binarySearch(square, j +1, i, expected );
                if(index > 0) {
                    found = true;
                    break;
                }
            }
        }
        return found ? "Yes" : "No";
    }
}
