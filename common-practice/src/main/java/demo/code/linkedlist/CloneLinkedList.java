package demo.code.linkedlist;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CloneLinkedList {

    /**
     * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     * @param args
     */
    public static void main(String[] args) {
        CloneLinkedList linkedList = new CloneLinkedList();
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);

        n7.next = n13;
        n7.random = null;

        n13.next = n11;
        n13.random = n7;

        n11.next = n10;
        n11.random = n1;

        n10.next = n1;
        n10.random = n11;

        n1.next = null;
        n1.random = n7;

        Node start = linkedList.copyRandomList(n7);
        System.out.println("Original ----------- ");
        linkedList.print(n7);
        System.out.println("Cloned ----------- ");
        linkedList.print(start);
    }

    public Node copyRandomList(Node head) {
        Node start = null;

        Node tmp = head;
        while (tmp != null) {
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            newNode.random = tmp.random;

            tmp.next = newNode;

            if (start == null) {
                start = newNode;
            }
            tmp = newNode.next;
        }

        tmp = start;
        // fix random links
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.random = tmp.random.next;
            }
            tmp = tmp.next;
            if (tmp != null) {
                tmp = tmp.next;
            }
        }

        tmp = head;
        // fix original list
        while (tmp != null) {
            Node copiedNode = tmp.next;
            if (copiedNode != null) {
                Node originalNode = copiedNode.next;
                tmp.next = originalNode;
                if (originalNode != null) {
                    copiedNode.next = originalNode.next;
                }
            }
            tmp = tmp.next;
        }

        return start;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int v) {
            val = v;
        }

        @Override
        public String toString() {
            return "(" + val + ')';
        }
    }

    private void print(Node head) {
        System.out.println("==========================");
        while (head != null) {
            System.out.printf("%d->[%s, %s]", head.val, head.next, head.random);
            head = head.next;
            if (head != null) {
                System.out.print("  --------->  ");
            }
        }
        System.out.println("\n==========================");
    }
}
