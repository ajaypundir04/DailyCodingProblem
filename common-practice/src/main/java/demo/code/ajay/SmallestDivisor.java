package demo.code.ajay;

public class SmallestDivisor {

    public static void main(String[] args) {
        System.out.println(findSmallestDivisor("rbrb", "rbrb"));
    }

    private static int findSmallestDivisor(String s, String t) {
        if (s.length() % t.length() != 0) {
            return -1;
        }
        if (isDivisible(s, t)) {
            return findPattern(t).length();
        }
        return -1;
    }

    static boolean isDivisible(String s, String t) {
        int l = s.length() / t.length();
        StringBuilder sb = new StringBuilder(t);
        for (int i = 1; i < l; i++) {
            sb.append(t);
        }
        return s.equals(sb.toString());
    }

    static String findPattern(String pattern) {
        int pend = 0;
        for (int j = 0; j < pattern.length(); j++) {
            int d = j % (pend + 1);
            if (pattern.charAt(d) != pattern.charAt(j)) {
                pend = j;
                continue;
            }

            if (j == pattern.length() - 1) {
                return pattern.substring(0, pend + 1);
            }
        }
        return pattern;
    }
}
