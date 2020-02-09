package demo.code.utils;

import demo.code.common.ListNode;

public class LinkedListUtils {

    public static ListNode createLinkedList(int... arr) {
        ListNode n = new ListNode(-1);
        ListNode nn = n;
        for (int i : arr) {
            nn.next = new ListNode(i);
            nn = nn.next;
        }
        return n.next;
    }
}
