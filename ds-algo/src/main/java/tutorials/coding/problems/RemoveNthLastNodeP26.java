package tutorials.coding.problems;

import tutorials.coding.common.ListNode;

public class RemoveNthLastNodeP26 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode start = head;
        ListNode delete = null;
        ListNode prev = null;
        while (start != null) {
            size++;
            int t = size - (n - 1);
            if (t > 0) {
                if (delete == null) {
                    delete = head;
                } else {
                    prev = delete;
                    delete = delete.getNext();
                }
            }
            start = start.getNext();
        }
        if (delete == null) {
            return null;
        } else if (delete.getNext() == null) { // last node
            if (prev == null) { // 1 node only
                return null;
            } else {
                prev.setNext(null);
            }
        } else {
            delete.setVal(delete.getNext().getVal());
            delete.setNext(delete.getNext().getNext());
        }
        return head;
    }
}
