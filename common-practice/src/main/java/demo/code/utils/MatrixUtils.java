package demo.code.utils;

public class MatrixUtils {

    public static void printMatrix( int[][] mat ) {

        for ( int i = 0; i < mat.length; i++ ) {
            System.out.println();
            for ( int j = 0; j < mat[ i ].length; j++ ) {
                System.out.printf( "%d  ", mat[ i ][ j ] );
            }
        }
    }
}
