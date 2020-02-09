package demo.code.google;

public class LongestStringPrefix {

    public static String longestCommonPrefix(String[] strs) {
        char ch;
        StringBuffer buffer = new StringBuffer();
        int i = 0, length = Integer.MAX_VALUE;
        for(String s:strs) {
            length = Math.min(length, s.length());
        }
        boolean explore = true;
        while(explore && i < length) {
            ch = '\u0000';
            for(String s:strs) {
                if(ch == '\u0000') {
                    //first case
                    ch = s.charAt(i);
                    continue;
                }

                if(ch != s.charAt(i)) {
                    explore = false;
                    break;
                }
            }
            if(explore)
                buffer.append(ch);
            i++;
        }
        return buffer.toString();
    }
}
