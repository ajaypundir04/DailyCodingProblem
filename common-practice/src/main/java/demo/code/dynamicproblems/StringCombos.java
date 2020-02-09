package demo.code.dynamicproblems;

import java.util.*;

public class StringCombos {

    public static void main(String[] args) {
        String str = "abcpol";
        Set<String> a = new TreeSet<>();
        a.add(str);
        for (int i = 0; i < str.length() - 1; i++) {
            a.addAll(printAllCombos(str.toCharArray(), i + 1));
        }
        System.out.println(a);
    }

    static List<String> printAllCombos(char[] ch, int k) {
        return print(ch, 0, "", k, new HashMap<>());
    }

    private static List<String> print(char[] ch, int start, String prefix, int k, Map<String, List<String>> cache) {
        if (cache.containsKey(prefix)) {
            return cache.get(prefix);
        }
        List<String> set = new ArrayList<>();
        if (k == 0) {
            set.add(prefix);
        } else {
            for (int i = start; i < ch.length; i++) {
                if (prefix.equals("" + ch[i])) {
                    set.addAll(print(ch, i + 1, prefix, k - 1, cache));
                } else {
                    set.addAll(print(ch, i + 1, prefix + ch[i], k - 1, cache));
                }
            }
        }
        cache.put(prefix, set);
        return set;
    }
}
