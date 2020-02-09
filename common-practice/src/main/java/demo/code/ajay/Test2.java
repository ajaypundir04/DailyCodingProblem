package demo.code.ajay;

import java.io.FileNotFoundException;
import java.util.*;

public class Test2 {

    public static void main(String[] args) {
//        int sum =0, a = 3;
//        while(sum++ < 3) {
//            int b = (1+2 * sum)%3;
//            switch (b) {
//                default:
//                case 0:
//                    a -= 1;
//                    break;
//                case 1:
//                    a += 5;
//            }
//        }
//        System.out.println(a);
//        List<Integer> list = new LinkedList<>();
//        list.add(-8);
//        list.add(10);
//        list.add(-20);
//        list.add(null);

//        List<String> list = new ArrayList<>(Arrays.asList("h", "a", "c"));
//        list.add(1, "k");
//        System.out.println(list.size());
//
//        list.remove("a");
//        list.remove(2);
//        System.out.println(new ArrayList<>().size());
//        System.out.println(list.size());

        Thread t = Thread.currentThread();
        System.out.println(t.getPriority());
    }

    int setValue() {
        int a = 10;
        int b = 20;

        try {
            ++a;
            b++;
            System.out.println("ERR");
        }finally {
            a++;
            b--;
        }
        return a+b;
    }
}
