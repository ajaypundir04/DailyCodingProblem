package tutorials.coding.problems;

import java.util.HashMap;
import java.util.Map;

public class P6XORLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(34);
        ll.get(1);
    }

    static class LinkedList<T> {

        LinkedNode<T> nodes;
        LinkedNode<T> head;
        LinkedNode<T> tail;
        private int size;

        private Map<Integer, LinkedList<T>> pointers;

        public LinkedList() {
            pointers = new HashMap<>();
        }

        public void add(T element) {
        }

        public T get(int index) {
            return null;
        }

        private int getPointer(LinkedNode<T> node) {
            return 0;
        }

        private LinkedNode<T> dereferencePointer(int pointer) {
            return null;
        }

    }


    static class LinkedNode<T> {
        private T value;
        private int both;

        public LinkedNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public int getBoth() {
            return both;
        }

        public void setBoth(int both) {
            this.both = both;
        }
    }
}
