package demo.code.hackerrank;

import java.util.Set;
import java.util.TreeSet;

public class EventsOrg {

    public static void main( String[] args ) {
//        int[] a = new int[]{ 1, 3, 3, 5, 7 };
//        int[] d = new int[]{ 2, 2, 1, 2, 1 };

//        int[] a = new int[]{ 1, 3, 5 };
//        int[] d = new int[]{ 2, 2, 2 };

        int[] a = new int[]{ 1, 1, 1, 1, 4 };
        int[] d = new int[]{ 10, 3, 6, 4, 2 };
        System.out.println( maxEvents( a, d ) );
    }

    static int maxEvents( int[] arrivalHour, int[] duration ) {
        Set<Data> d = new TreeSet<>(  );
        for(int i =0; i < arrivalHour.length; i ++) {
            d.add( new Data( arrivalHour[i], duration[i] ) );
        }
        Ground g = new Ground( 0, 0 );
        d.forEach( tmp -> g.arrive( tmp.a, tmp.d ) );
        return g.getTotal();
    }

    static class Data implements Comparable<Data> {
        private int a;
        private int d;

        public Data( int a, int d ) {
            this.a = a;
            this.d = d;
        }

        @Override
        public int compareTo( Data a1 ) {
            return Integer.compare( a1.a, a );
        }
    }

    static class Ground {
        private int arrival;
        private int duration;

        private int total;

        public Ground( int arrival, int duration ) {
            this.arrival = arrival;
            this.duration = duration;
            total = 0;
        }

        public void arrive( int a, int d ) {
            if ( a >= ( arrival + duration ) ) {
                this.arrival = a;
                this.duration = d;
                this.total += 1;
            } else if( a == arrival && d < duration) {
                this.duration = d;
            }
        }

        public int getTotal() {
            return total;
        }
    }
}
