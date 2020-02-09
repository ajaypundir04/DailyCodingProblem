package demo.code.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AddNumbersLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(3, 7, 5));
        new AddNumbersLinkedList().add(l1, l2);
    }

    private void add(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> result = new Stack<>();

        for (Integer i : l1) {
            s1.push(i);
        }

        for (Integer i : l2) {
            s2.push(i);
        }
        int carry = 0;
        while (!s1.empty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();

            int sum = a + b + carry;

            carry = sum / 10;
            sum = sum % 10;

            result.push(sum);
        }
        while (!result.isEmpty()) {
            System.out.print(result.pop());
        }
    }
}
