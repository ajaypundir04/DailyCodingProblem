package tutorials.coding.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static tutorials.coding.utils.ArrayUtils.array;
import static tutorials.coding.utils.MapUtils.entry;
import static tutorials.coding.utils.MapUtils.ofEntries;

public class Problem2Test {

    private Problem2 problem2;

    @BeforeEach
    public void setup() {
        problem2 = new Problem2();
    }

    @TestFactory
    public Stream<DynamicTest> transform() {
        Map<int[], int[]> data = ofEntries(
                entry(array(1, 2, 3, 4, 5), array(120, 60, 40, 30, 24)),
                entry(array(3, 2, 1), array(2, 3, 6))
        );

        return data.entrySet().stream().map(e ->
                DynamicTest.dynamicTest(
                        "Testing for: " + Arrays.toString(e.getKey()),
                        () -> {
                            int[] result = problem2.transform(e.getKey());
                            assertArrayEquals(e.getValue(), result);
                        }
                )
        );
    }
}