package demo.code.leetcode;

public class GCD {

    public static void main( String[] args ) {

        System.out.println(
                gcd( 56, 49 )
        );
    }

    static int gcd( int x, int y ) {
        if ( x == 0 ) return y;
        return gcd( y % x, x );
    }
}
