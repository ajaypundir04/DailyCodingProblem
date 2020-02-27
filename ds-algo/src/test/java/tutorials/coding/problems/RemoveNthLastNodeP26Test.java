package tutorials.coding.problems;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import tutorials.coding.common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveNthLastNodeP26Test {

    RemoveNthLastNodeP26 nodeP26 = new RemoveNthLastNodeP26();

    @TestFactory
    public Stream<DynamicTest> testRemoveNthNode() {
        return Arrays.asList(
                new Data(ll(1, 2, 3, 4, 5), 2, ll(1, 2, 3, 5)),
                new Data(ll(1, 2, 3, 4, 5), 3, ll(1, 2, 4, 5)),
                new Data(ll(1, 2, 3, 4, 5), 4, ll(1, 3, 4, 5)),
                new Data(ll(1, 2, 3, 4, 5), 5, ll(2, 3, 4, 5))
        ).stream().map(d -> DynamicTest.dynamicTest(
                toString(d.input), () -> {
                    ListNode result = nodeP26.removeNthFromEnd(d.input, d.k);
                    assertTrue(equals(d.output, result));
                }
        ));
    }

    static class Data {
        ListNode input;
        int k;
        ListNode output;

        public Data(ListNode input, int k, ListNode output) {
            this.input = input;
            this.k = k;
            this.output = output;
        }
    }

    static ListNode ll(int... arr) {
        ListNode start = new ListNode(-1);
        ListNode head = start;
        for (int i : arr) {
            ListNode newNode = new ListNode(i);
            start.setNext(newNode);
            start = newNode;
        }
        return head.getNext();
    }

    static String toString(ListNode l) {
        StringBuilder s = new StringBuilder();
        while (l != null) {
            s.append(l.getVal()).append(",");
            l = l.getNext();
        }
        return s.toString().substring(0, s.length() - 1);
    }

    static boolean equals(ListNode l1, ListNode l2) {
        Set<Integer> s1 = toSet(l1);
        Set<Integer> s2 = toSet(l2);
        return s1.equals(s2);
    }

    static Set<Integer> toSet(ListNode l) {
        Set<Integer> s = new HashSet<>();
        while (l != null) {
            s.add(l.getVal());
            l = l.getNext();
        }
        return s;
    }

}