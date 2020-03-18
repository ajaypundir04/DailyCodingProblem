package tutorials.algos.sorting;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static tutorials.utils.ArrayUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @TestFactory
    public Stream< DynamicTest > testSortUsingRecursion() {
        return Stream.of(
                new Data(
                        array( 10, 80, 30, 90, 40, 50, 70 ),
                        array( 10, 30, 40, 50, 70, 80, 90 ),
                        QuickSort.PivotSelection.ALWAYS_LAST
                ),
                new Data( array( 4 ), array( 4 ), QuickSort.PivotSelection.ALWAYS_LAST ),
                new Data( array( 10, 3 ), array( 3, 10 ), QuickSort.PivotSelection.ALWAYS_LAST ),
                new Data( array( 10, 3, 12 ), array( 3, 10, 12 ), QuickSort.PivotSelection.ALWAYS_LAST )
        ).map( d -> DynamicTest.dynamicTest(
                String.format( "Testing for : %s", Arrays.toString( d.source ) ),
                () -> {
                    quickSort.sortUsingRecursion( d.source, d.pivotSelection );
                    assertArrayEquals( d.expected, d.source );
                }
        ) );
    }

    static class Data {
        int[] source;
        int[] expected;
        QuickSort.PivotSelection pivotSelection;

        public Data( int[] source, int[] expected, QuickSort.PivotSelection pivotSelection ) {
            this.source = source;
            this.expected = expected;
            this.pivotSelection = pivotSelection;
        }
    }
}