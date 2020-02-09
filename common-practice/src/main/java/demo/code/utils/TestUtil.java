package demo.code.utils;

public class TestUtil {

    public static void main(String[] args) {
        int i = 2;
        System.out.println("Before: "+i);
        go(i);
        System.out.println("After: "+i);
    }

    static void go(int i ) {
        System.out.println(i++);
    }
}
