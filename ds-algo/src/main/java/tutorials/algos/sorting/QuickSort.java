package tutorials.algos.sorting;

import tutorials.utils.ArrayUtils;

public class QuickSort {

    public static void main( String[] args ) {
        new QuickSort().sortUsingRecursion( ArrayUtils.array( 4, 2 ), PivotSelection.ALWAYS_LAST );
    }

    public void sortUsingRecursion( int[] array, PivotSelection pivotSelection ) {

        quickSortAlgorithm( array, 0, array.length - 1, pivotSelection );
    }

    public void sortUsingIteration( int[] ar ) {

    }

    private void quickSortAlgorithm( int[] ar, int low, int high, PivotSelection pivotSelection ) {
        if ( low <= high ) {
            int pivotIndex = partition( ar, low, high, pivotSelection );

            quickSortAlgorithm( ar, low, pivotIndex - 1, pivotSelection );
            quickSortAlgorithm( ar, pivotIndex + 1, high, pivotSelection );
        }
    }

    private int partition( int[] ar, int low, int high, PivotSelection pivotSelection ) {
        int pivotIndex = pivotSelection.index( ar, low, high );
        int pivot = ar[ pivotIndex ];

        int smallIndex = low - 1;

        for ( int i = low; i <= ( high - 1 ); i++ ) {
            if ( ar[ i ] < pivot ) {
                smallIndex++;
                ArrayUtils.swap( ar, smallIndex, i );
            }
        }
        ArrayUtils.swap( ar, smallIndex + 1, pivotIndex );
        return smallIndex + 1;
    }


    enum PivotSelection {
        //        ALWAYS_FIRST,
        ALWAYS_LAST;
//        RANDOM,
//        MEDIAN;

        int index( int[] arr, int start, int end ) {
            if ( this == ALWAYS_LAST ) {
                return end;
            } else {
                return start;
            }
        }
    }
}
