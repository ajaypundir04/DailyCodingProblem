package demo.code.common;

public class ListNode {

    int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public int getVal() {
        return val;
    }
}
