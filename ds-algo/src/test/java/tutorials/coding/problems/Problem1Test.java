package tutorials.coding.problems;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static tutorials.coding.utils.ArrayUtils.array;

public class Problem1Test {

    private Problem1 problem1;
    private Stream<Data> dataStream;

    @BeforeEach
    public void setup() {
        problem1 = new Problem1();
        dataStream = Stream.of(
                new Data(array(10, 15, 3, 7), 17, true),
                new Data(array(10, 15, 3, 7), 20, false),
                new Data(array(10, 15, 3, 7), 13, true),
                new Data(array(10, 15, 3, 7), 15, false),
                new Data(array(10, 15, 3, 7), 10, true),
                new Data(array(10, 15, 3, 7), 28, false),
                new Data(array(10, 15, 3, 7), 27, false)
        );
    }

    @TestFactory
    public Stream<DynamicTest> findSumUsingAuxiliarySpace() {
        return dataStream.map(d -> DynamicTest.dynamicTest(
                String.format("Finding sum %d in array: %s", d.sum, Arrays.toString(d.array)), () -> {
                    boolean actual = problem1.findSumUsingAuxiliarySpace(d.array, d.sum);
                    Assertions.assertEquals(d.result, actual);
                }
        ));
    }

//    @TestFactory
//    public Stream<DynamicTest> findSumRecursively() {
//        return dataStream.map(d -> DynamicTest.dynamicTest(
//                String.format("Finding sum %d in array: %s", d.sum, Arrays.toString(d.array)), () -> {
//                    boolean actual = problem1.findSumRecursively(d.array, d.sum);
//                    Assertions.assertEquals(d.result, actual);
//                }
//        ));
//    }

    static class Data {
        private int[] array;
        private int sum;
        private boolean result;

        public Data(int[] array, int sum, boolean result) {
            this.array = array;
            this.sum = sum;
            this.result = result;
        }
    }
}