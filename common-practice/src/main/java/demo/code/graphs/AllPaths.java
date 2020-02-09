package demo.code.graphs;

import java.util.*;

public class AllPaths {

    public static void main( String[] args ) {
        AllPaths ap = new AllPaths();
        int[][] graph = generateGraph();
        int start = 0;
        int end = 3;
//        System.out.println( ap.allPathsSourceTarget( graph ) );
        ap.exploreUsingBFS( graph, start, end ).forEach( ap::printPath );
    }

    static int[][] generateGraph() {
        return
                new int[][]{
                        { 3, 1, 2 },
                        { 3 },
                        { 0, 1 },
                        {}
//                        { 1, 2 },
//                        { 3 },
//                        { 3 },
//                        {}
                };
    }

    public List< List< Integer > > allPathsSourceTarget( int[][] graph ) {
        int v = graph.length;

        boolean[] visited = new boolean[ graph.length ];

        return explore( graph, 0, 3, visited, new ArrayList<>( Collections.singletonList( 0 ) ) );
    }

    private List< List< Integer > > exploreUsingBFS( int[][] graph, int start, int end ) {
        List< List< Integer > > result = new ArrayList<>();
        List< Integer > path = new ArrayList<>( List.of( start ) );
        Queue< List< Integer > > storage = new LinkedList<>();
        storage.add( path );

        while ( !storage.isEmpty() ) {
            List< Integer > p = storage.poll();
            int item = p.get( p.size() - 1 );
            if ( item == end ) {
                result.add( p );
            } else {
                for ( int i = 0; i < graph[ item ].length; i++ ) {
                    if ( !isVisited( path, graph[ item ][ i ] ) ) {
                        List< Integer > newList = new ArrayList<>( p );
                        newList.add( graph[ item ][ i ] );
                        storage.add( newList );
                    }
                }
            }
        }
        return result;
    }

    private boolean isVisited( List< Integer > path, int v ) {
        return path.contains( v );
    }

    private List< List< Integer > > explore( int[][] adj, int u, int d, boolean[] visited, List< Integer > localVisited ) {
        List< List< Integer > > result = new ArrayList<>();

        visited[ u ] = true;
        if ( u == d ) {
            result.add( localVisited );
            visited[ u ] = false;
        }

        for ( int i = 0; i < adj[ u ].length; i++ ) {
            int v = adj[ u ][ i ];
            if ( !visited[ v ] ) {
                List< Integer > al = new ArrayList<>( localVisited );
                al.add( v );
                result.addAll( explore( adj, v, d, visited, al ) );
            }
        }
        return result;
    }

    private void printPath( List< Integer > ints ) {
        for ( int i : ints ) {
            System.out.print( i + " -> " );
        }
        System.out.println( "NULL" );
    }
}
