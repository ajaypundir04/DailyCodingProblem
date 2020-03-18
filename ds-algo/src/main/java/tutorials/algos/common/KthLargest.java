package tutorials.algos.common;

import tutorials.utils.ArrayUtils;

public class KthLargest {

    public static void main( String[] args ) {
        // SORTED ARRAY =        10, 30, 40, 50, 70, 80, 90 };
        int[] array = new int[]{ 10, 80, 30, 90, 40, 50, 70 };
        // SORTED ARRAY =         1, 2, 2, 2, 3
        int[] array1 = new int[]{ 3, 2, 1, 2, 2 };

        KthLargest largest = new KthLargest();
        KthSmallest smallest = new KthSmallest();

        for ( int i = 1; i <= array1.length; i++ ) {
            System.out.printf(
                    i + "th [Largest: %d] [Smallest: %d]\n",
                    largest.findNumber( array1, i ),
                    smallest.findNumber( array1, i )
            );
        }
    }

    public int findNumber( int[] ar, int k ) {
        int kIndex = findIndex( ar, 0, ar.length - 1, k );
        if ( kIndex >= 0 ) {
            return ar[ kIndex ];
        }
        return -1;
    }

    private int findIndex( int[] ar, int low, int high, int k ) {
        if ( low <= high ) {
            int pivotIndex = partition( ar, low, high );
            int kIndex = ar.length - k;
            if ( pivotIndex == kIndex ) {
                return pivotIndex;
            } else {
                if ( pivotIndex > kIndex ) {
                    // item on left
                    return findIndex( ar, low, pivotIndex - 1, k );
                } else {
                    // item on right
                    return findIndex( ar, pivotIndex + 1, high, k );
                }
            }
        }
        return -1;
    }

    private int partition( int[] ar, int low, int high ) {
        int pivot = ar[ high ];

        int smallIndex = low - 1;
        for ( int i = low; i <= ( high - 1 ); i++ ) {
            if ( ar[ i ] < pivot ) {
                smallIndex++;
                ArrayUtils.swap( ar, smallIndex, i );
            }
        }
        ArrayUtils.swap( ar, smallIndex + 1, high );
        return smallIndex + 1;
    }
}
