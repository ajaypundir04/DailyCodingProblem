package demo.code.ajay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialNumber {

    public static void main(String[] args) {
//        System.out.println(new SpecialNumber().cost(4, 8, 7));
        System.out.println(new SpecialNumber().cost(20, 1, 1));
        System.out.println(new SpecialNumber().cost(16, 1, 1));
        System.out.println(new SpecialNumber().cost(50, 1, 1));
    }

    public int cost(int n, int inc, int dec) {
        int s = findPrimePair(n);
        if(s > 0) {
            return inc * s;
        } else {
            return dec * s;
        }
    }

    static void generatePrimes(int n, boolean isPrime[]) {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (i % 2 != 0)
                isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
    }

    static int findPrimePair(int n) {
        List<Integer> primes = primeSequence(4);
        int pow = 1;
        Map<Integer, V> map = new TreeMap<>();
        for (int i = 0; i < primes.size() - 1; i++) {
            int sum = (int) Math.pow(primes.get(i), pow) + (int) Math.pow(primes.get(i+1), pow);
            int diff = Math.abs(sum - n);
            map.put(diff, new V(pow, primes.get(i), primes.get(i+1)));
        }
        System.out.println(map);
        Map.Entry<Integer, V> ent = map.entrySet().stream().findFirst().get();
        V v = ent.getValue();
        return (int)(Math.pow(v.p1, v.pow) + Math.pow(v.p2, v.pow)) - n;
    }

    static class V {
        int pow;
        int p1, p2;

        public V(int pow, int p1, int p2) {
            this.pow = pow;
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return "V{" +
                    "pow=" + pow +
                    ", p1=" + p1 +
                    ", p2=" + p2 +
                    '}';
        }
    }

    public static boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    public static List<Integer> primeSequence(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(SpecialNumber::isPrime)
                .filter(i -> i % 2 != 0)
                .limit(n)
                .boxed()
                .collect(Collectors.toList());
    }
}
