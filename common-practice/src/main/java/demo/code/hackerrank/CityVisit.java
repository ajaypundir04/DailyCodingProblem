package demo.code.hackerrank;

import java.util.*;

public class CityVisit {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        MyClass solver = new MyClass();
        int ans = solver.solve( sc );
        System.out.println( ans );
    }

}

class MyClass {

    public int solve( Scanner in ) {
        int maxCoins;
        int totalCities;
        int totalRoads;
        Map< String, Path > paths = new HashMap<>();

        maxCoins = in.nextInt();
        totalCities = in.nextInt();
        totalRoads = in.nextInt();
        for ( int i = 0; i < totalRoads; i++ ) {
            String line = in.nextLine();
            int s = in.nextInt();
            int d = in.nextInt();
            int rl = in.nextInt();
            int t = in.nextInt();
            String key = String.valueOf( s ).concat( String.valueOf( d ) );
            List< Path > l = new ArrayList<>();

            Collections.sort( l, ( a, b ) -> Integer.compare( a.getRoadLength(), b.getRoadLength() ) );
        }
        return 0;


    }

    public static void main( String[] args ) {
        int arr[][] = {
                { 1, 2, 2, 3 },
                { 2, 3, 3, 6 },
                { 2, 3, 2, 8 },
                { 2, 3, 2, 5 },
                { 2, }
        };
        int st = 1;
        int k = 10;
        int len = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( arr[ i ][ 0 ] == st ) {
                st = arr[ i ][ 1 ];
                k = k - arr[ i ][ 2 ];
                len += arr[ i ][ 3 ];
            }
        }
    }
}

class Path implements Comparable< Path > {
    private int roadLength;
    private int toll;

    public Path( int roadLength, int toll ) {
        this.roadLength = roadLength;
        this.toll = toll;
    }

    public int getRoadLength() {
        return roadLength;
    }

    public int getToll() {
        return toll;
    }

    @Override
    public int compareTo( Path path ) {
        return Integer.compare( path.toll, this.toll );
    }
}
