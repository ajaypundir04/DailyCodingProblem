package demo.code.ajay;

import java.util.ArrayList;
import java.util.Spliterator;

public class Test1 {

    public static void main(String[] args) {
        ArrayList<Double> vals = new ArrayList<>();
        vals.add(1.0);
        vals.add(4.0);
        vals.add(16.0);

        Spliterator<Double> sp = vals.spliterator();
        while(sp.tryAdvance((n) -> System.out.println(" "+n)));
        System.out.println();
        sp = vals.spliterator();

        ArrayList<Double> sq = new ArrayList<>();
        while(sp.tryAdvance(n -> sq.add(Math.sqrt(n))));
        sp = sq.spliterator();
        sp.forEachRemaining((n) -> System.out.println(" "+n));
    }
}
