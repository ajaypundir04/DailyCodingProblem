package demo.code.google;

import org.w3c.dom.ls.LSOutput;

public class MathDemo {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    static int divide(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        int a = x == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(x);
        int b = y == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(y);
        System.out.println(Math.abs(a));
        System.out.println(Math.abs(b));
        return a/b;
    }
}
