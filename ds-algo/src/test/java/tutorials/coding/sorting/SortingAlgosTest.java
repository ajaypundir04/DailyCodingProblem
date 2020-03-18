package tutorials.coding.sorting;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static tutorials.utils.MapUtils.*;
import static tutorials.utils.ArrayUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortingAlgosTest {

    SortingAlgos sortingAlgos = new SortingAlgos();

    @TestFactory
    Stream<DynamicTest> insertionSort() {

        List<Map.Entry<int[], int[]>> entries = IntStream.range(0, 5)
                .mapToObj(i -> randomArray(10 + i))
                .map(arr -> entry(arr, sort(arr)))
                .collect(Collectors.toList());
        return entries.stream()
                .map(e -> DynamicTest.dynamicTest(
                        "Testing for: " + Arrays.toString(e.getKey()),
                        () -> {
                            int[] k = e.getKey();
                            sortingAlgos.insertionSort(k);
                            assertArrayEquals(e.getValue(), k);
                            System.out.println(Arrays.toString(k));
                        }
                ));
    }
}