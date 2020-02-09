package demo.code.google;

import demo.code.common.ListNode;

public class RemoveNthNodeFromLL {

    public static void main(String[] args) {
        RemoveNthNodeFromLL l = new RemoveNthNodeFromLL();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        root = l.removeNthFromEnd(root, 5);

        ListNode.print(root);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        int nodeToDelete;

        ListNode tmp = head;

        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        nodeToDelete = (size - (n - 1));

        int nodeCount = 1;
        if (nodeToDelete > 0) {
            tmp = head;
            ListNode prev = null;
            while (tmp != null) {
                if (nodeToDelete == nodeCount) {
                    if (nodeToDelete == 1) {
                        head = head.next;
                    } else {
                        if (tmp.next == null) {
                            prev.next = null;
                        } else {
                            prev.next = tmp.next;
                        }
                    }
                    break;
                }

                nodeCount++;
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
