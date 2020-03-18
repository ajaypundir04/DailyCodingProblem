package tutorials.algos.common;

public class KthSmallest {
    private KthLargest largest = new KthLargest();

    public int findNumber( int[] ar, int k ) {
        int j = ar.length - (k - 1);
        return largest.findNumber( ar, j );
    }
}
