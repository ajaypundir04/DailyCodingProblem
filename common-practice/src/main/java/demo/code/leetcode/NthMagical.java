package demo.code.leetcode;

import java.math.BigInteger;

public class NthMagical {

    public static void main( String[] args ) {
        int n = 1000000000;
        int e = 999720007;
        int x = 969572352;
        int mod = (int) Math.pow( 10, 9 ) + 7;
//        System.out.println( n );
//        System.out.println(
//                nthMagicalNumber( n, 40000, 40000 )
//        );

        int v = (int)(((long)n * 40000) % mod);
        System.out.println(v);

        long V = (n * 40000) % mod;
        System.out.println(V);

        long z = ((long)n * 40000) % mod;
        System.out.println(z);
    }

    public static int nthMagicalNumber( int N, int A, int B ) {
        int count = 0;
        int mod = ( int ) Math.pow( 10, 9 ) + 7;
        int a_index = 1;
        int b_index = 1;
        long num = Math.min( A, B );

        while ( count < N ) {
            long val = ( long ) A * a_index;
            a_index++;
            num = val;
//            long b_next = B * b_index;

//            if(a_next < b_next) {
//                num = a_next;
//                a_index++;
//            } else if(b_next < a_next) {
//                num = b_next;
//                b_index++;
//            } else {
//                num = a_next;
//                a_index++;
//                b_index++;
//            }
            count++;
        }
        System.out.println( " a-index: " + a_index );
        System.out.println( " Counter: " + count );
        System.out.println( " Number : " + num );
        return ( int ) (num % mod);
    }
}

class A {
    public int nthMagicalNumber( int N, int A, int B ) {
        int mod = ( int ) Math.pow( 10, 9 ) + 7;
        return ( A == B ) ? countForSame( N, A, mod ) : countForBoth( N, A, B, mod );
    }

    private int countForSame( int N, int A, int mod ) {
        int count = 0;
        int a_index = 1;
        long val = 0;
        while ( count < N ) {
            val = ( long ) A * a_index;
            a_index++;
            count++;
        }
        return ( int ) ( val % mod );
    }

    private int countForBoth( int N, int A, int B, int mod ) {
        int count = 0;
        int a_index = 1;
        int b_index = 1;
        long num = 0;
        while ( count < N ) {
            long a_next = ( long ) A * a_index;
            long b_next = ( long ) B * b_index;

            if ( a_next < b_next ) {
                num = a_next;
                a_index++;
            } else if ( b_next < a_next ) {
                num = b_next;
                b_index++;
            } else {
                num = a_next;
                a_index++;
                b_index++;
            }
            count++;
        }
        return ( int ) ( num % mod );
    }
}
