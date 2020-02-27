package tutorials.coding.problems;

import tutorials.coding.common.ListNode;

public class RemoveNthLastNodeP26 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        int t = 0;
        ListNode start = head;
        ListNode found = null;
        int diff = n - 1;
        while (start != null) {
            size++;
            t = size - diff;
            if (t > 0) {
                if (found == null) {
                    found = head;
                } else {
                    found = found.getNext();
                }
            }
            start = start.getNext();
        }
        if (found != null && found.getNext() != null) {
            found.setVal(found.getNext().getVal());
            found.setNext(found.getNext().getNext());
        }
        return head;
    }
}
