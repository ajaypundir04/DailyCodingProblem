package tutorials.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public final class ArrayUtils {

    public static int[] array(int... nums) {
        return nums;
    }

    public static int[] randomArray(int length) {
        return randomArray(length, 1000);
    }

    public static int[] randomArray(int length, int numberLimit) {
        Random r = new Random();
        return IntStream.range(0, length).map(i -> r.nextInt(numberLimit)).toArray();
    }

    public static int[] sort(int[] array) {
        int[] dup = Arrays.copyOf(array, array.length);
        Arrays.sort(dup);
        return dup;
    }

    public static void swap( int[] ar, int i, int j ) {
        if ( isIndexInRange( ar, i ) && isIndexInRange( ar, j ) ) {
            int tmp = ar[ i ];
            ar[ i ] = ar[ j ];
            ar[ j ] = tmp;
        }
    }

    private static boolean isIndexInRange( int[] ar, int index ) {
        return ( index >= 0 && index < ar.length );
    }
}
