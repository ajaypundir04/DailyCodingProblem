package demo.code.google;

import java.util.BitSet;

public class ReverseInt {

    public static void main(String[] args) {
//        System.out.println(reverse(100));
//        System.out.println(reverse(-384));
//        System.out.println(reverse(900000));
//        int v = 1534236469;
//        System.out.println();
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE - v);
//
        for(char ch='0'; ch <= '9'; ch++) {
            int num = ch-48;
            System.out.println(ch+" ("+(int)ch+") " + " - "+num);
        }

        System.out.println(-3 * 2);

    }

    public static int reverse(int x) {
        int result=0;
        boolean isNegative = (x & 0x800000) > 0;
        x = Math.abs(x);
        while(x>0) {
            result = (result * 10) + (x %10);
            x /=10;
        }
        return result * (isNegative ? -1 : 1);
    }
}
