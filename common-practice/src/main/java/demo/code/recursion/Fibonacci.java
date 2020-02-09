package demo.code.recursion;

public class Fibonacci {

    static int calls = 0;
    static int mamoCalls = 0;
    static int []cache = new int[100];

    public static void main(String[] args) {
        int num = 40;
        int ans = fib(num);
        int ans1 = fibMamoized(num);
        System.out.printf("Fib of %d is %d and it's took %s calls\n", num, ans, calls);
        System.out.printf("MAMOIZED Fib of %d is %d and it's took %s calls", num, ans1, mamoCalls);
    }

    private static int fib(int n) {
        calls++;
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibMamoized(int n) {
        mamoCalls++;
        if (n < 2) {
            return n;
        }
        int a;
        int b;
        if(cache[n-1] != 0) {
            a = cache[n-1];
        } else {
            a = fibMamoized(n - 1);
            cache[n-1] = a;
        }

        if(cache[2-1] != 0) {
            b = cache[n-2];
        } else {
            b = fibMamoized(n - 2);
            cache[n-2] = b;
        }
        return a + b;
    }
}
