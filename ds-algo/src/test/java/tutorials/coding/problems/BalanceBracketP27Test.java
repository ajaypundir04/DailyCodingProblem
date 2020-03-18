package tutorials.coding.problems;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tutorials.utils.MapUtils.entry;
import static tutorials.utils.MapUtils.ofEntries;

public class BalanceBracketP27Test {

    private BalanceBracketP27 bracket = new BalanceBracketP27();

    @TestFactory
    public Stream<DynamicTest> bracketBalance() {
        Map<String, Boolean> data = ofEntries(
                entry("([])[]({})", true),
                entry("([)]", false),
                entry("((()", false)
        );
        return data.entrySet()
                .stream().map(e -> DynamicTest.dynamicTest(e.getKey(), () -> {
                    boolean result = bracket.bracketBalance(e.getKey());
                    assertEquals(e.getValue(), result);
                }));
    }

    @TestFactory
    public Stream<DynamicTest> bracketBalanceApproach2() {
        Map<String, Boolean> data = ofEntries(
                entry("([])[]({})", true),
                entry("([)]", false),
                entry("((()", false)
        );
        return data.entrySet()
                .stream().map(e -> DynamicTest.dynamicTest(e.getKey(), () -> {
                    boolean result = bracket.bracketBalance1(e.getKey());
                    assertEquals(e.getValue(), result);
                }));
    }
}