package demo.code.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ThrottlingGateway {

    public static void main( String[] args ) {
        System.out.println( "DROP COUNT = " + dropCount( new int[]{ 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3 } ) );
    }

    static int dropCount( int[] t ) {

        int[] ar = filter( t, 1, 3 );
        ar = filter( ar, 10, 20 );
        ar = filter( ar, 60, 60 );
        return t.length - ar.length;
    }

    static int[] filter( int[] t, int window, int allowed ) {
        List< Integer > data = new ArrayList<>();
        int counter = 0;
        int windowStart = t[ 0 ];
        int w = windowStart + window;
        for ( int i = 0; i < t.length; i++ ) {
            int tmp = t[ i ];
            if ( tmp >= windowStart && tmp < w ) {
                counter++;
                if ( counter <= allowed ) {
                    data.add( tmp );
                }
            } else {
                windowStart = w;
                w += window;
                counter = 1;
            }
        }
        return data.stream().mapToInt( Integer::intValue ).toArray();
    }
}
