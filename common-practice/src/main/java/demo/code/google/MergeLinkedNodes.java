package demo.code.google;

import demo.code.common.ListNode;

public class MergeLinkedNodes {

    public static void main(String[] args) {
        MergeLinkedNodes m = new MergeLinkedNodes();

        ListNode l1 = m.createLL(1, 4, 5);
        ListNode l2 = m.createLL(1, 3, 4);
        ListNode l3 = m.createLL(2, 6);

        ListNode mergedNode = m.merge(new ListNode[]{l1, l2, l3});
        ListNode.print(mergedNode);
    }

    private ListNode createLL(int... vals) {
        ListNode root = new ListNode(0);
        ListNode tmp = root;
        for (int i : vals) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return root.next;
    }

    private ListNode merge(ListNode[] lists) {
        int index = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].getVal() < minVal) {
                minVal = lists[i].getVal();
                index = i;
            }
        }

        if (index >= 0) {
            ListNode n = lists[index];
            lists[index] = n.next;
            n.next = merge(lists);
            return n;
        }
        return null;
    }
}
