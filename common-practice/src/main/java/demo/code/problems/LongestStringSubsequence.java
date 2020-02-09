package demo.code.problems;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestStringSubsequence {

    public static void main(String[] args) {
        String n = "abcabcab";
        String regex = "^(?:([A-Za-z])(?!.*\\\\1))*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(n);
        MatchResult result
                = matcher.toMatchResult();
        System.out.println("Current Matcher: "
                + result);

        while (matcher.find()) {
            // Get the group matched using group() method
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group());
        }
    }

    public int lengthOfLongestSubstring(String s) {

        int length = 0;
        int maxLength = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        char[] ch = s.toCharArray();
        byte[] b = new byte[127];
        byte monitor = 1;
        for (int i = 0; i < ch.length; i++) {
            if (b[ch[i]] != monitor) {
                length++;
            } else {
                monitor++;
                maxLength = Integer.max(maxLength, length);
                length = 1;
            }
            b[ch[i]] = monitor;
        }
        return Integer.max(maxLength, length);
    }

//    public int lengthOfLongestSubstring(String s) {
//        int length = 0;
//        int maxLength = 0;
//        if (s.length() <= 1) {
//            return s.length();
//        }
//        char[] ch = s.toCharArray();
//        byte[] b = new byte[127];
//        byte monitor = 1;
//        for (int i = 0; i < ch.length; i++) {
//            if (b[ch[i]] != monitor) {
//                length++;
//            } else {
//                monitor++;
//                maxLength = Integer.max(maxLength, length);
//                length = 1;
//            }
//            b[ch[i]] = monitor;
//        }
//        return Integer.max(maxLength, length);
//    }
}
