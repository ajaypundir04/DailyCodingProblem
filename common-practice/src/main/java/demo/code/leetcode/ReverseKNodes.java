package demo.code.leetcode;

import demo.code.common.ListNode;
import demo.code.common.Run;
import demo.code.utils.LinkedListUtils;

import java.util.Stack;

public class ReverseKNodes {

    public static void main(String... args) {
        ListNode head = LinkedListUtils.createLinkedList(1, 2, 3, 4, 5);
        ListNode.print(head);

        head = new ReverseKNodes().reverseKGroup(head, 2);
        ListNode.print(head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = new ListNode(-1);
        l.next = head;
        int count = 0;
        ListNode start = l;
        ListNode pointer = l;
        while (pointer != null) {
            if (count > 0 && count % k == 0) {
                start = reverse(start, pointer, k);
                pointer = start;
            }
            pointer = pointer.next;
            count++;
        }
        return l.next;
    }

    private ListNode reverse(ListNode start, ListNode end, int k) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode lastNode = end.next;
        ListNode n = start.next;
        while (n != null && n != lastNode) {
            nodes.push(n);
            n = n.next;
        }

        n = start;
        while (!nodes.isEmpty()) {
            n.next = nodes.pop();
            n = n.next;
        }
        n.next = lastNode;
        return n;
    }
}
