package demo.code.hackerrank;


import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//public class InterfaceTest {

//    public static void main( String[] args )  {
//        try {
//
//            C o = new C("Hello", -7, 2.1e10);
//            FileOutputStream fos = new FileOutputStream( "serail" );
//            ObjectOutputStream oo = new ObjectOutputStream( fos );
//            oo.writeObject( o );
//            oo.flush();
//            oo.close();
//        } catch ( Exception e ) {
//            System.out.println("Ser Er" + e);
//            System.exit( 0 );
//        }
//        try {
//            int x;
//            FileInputStream fis = new FileInputStream( "serail" );
//            ObjectInputStream oi = new ObjectInputStream( fis );
//            x = oi.readInt();
//            oi.close();
//            System.out.println(x);
//        } catch ( Exception e ) {
//            System.out.println("Des Ex");
//            System.exit( 0 );
//        }
//    }


//    public  void m(StringBuffer sb) {
//        System.out.println("SB");
//    }
//
//    public  void m(String s) {
//        System.out.println("S");
//    }
//
//    public static void main( String[] args ) {
//
//
//    }
//}
class A {
    {
        System.out.println("A");
    }

    public A () {
        System.out.println("B");
    }

    static {
        System.out.println("E");
    }
}

class B extends A {
    static {
        System.out.println("C");
    }

    public B() {
        System.out.println("D");
    }
}

public class InterfaceTest extends B {
    public static void main( String[] args ) {
        System.out.println("Before");

        new InterfaceTest();
        System.out.println("After");
    }
}