package tutorials.coding.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import tutorials.coding.utils.ArrayUtils;
import tutorials.coding.utils.MapUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Problem4Test {

    private Problem4 problem4 = new Problem4();

    @TestFactory
    Stream<DynamicTest> bruteForceSolutionTest() {

        Map<int[], Integer> data = MapUtils.ofEntries(
                MapUtils.entry(ArrayUtils.array(3, 4, -1, 1), 2),
                MapUtils.entry(ArrayUtils.array(1, 2, 0), 3),
                MapUtils.entry(ArrayUtils.array(1, 2, 1), 3),
                MapUtils.entry(ArrayUtils.array(5, 7, -1, 8, 9), 6)
        );

        return data.entrySet().stream().map(e -> DynamicTest.dynamicTest(
                "Testing for: " + Arrays.toString(e.getKey()),
                () -> {
                    int actual = problem4.bruteForceSolution(e.getKey());
                    Assertions.assertEquals(e.getValue(), actual);
                }
        ));
    }
}