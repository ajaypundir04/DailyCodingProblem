package demo.code.google;

enum Result {
    TRUE, FALSE
}
public class CustomRegex {

    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (
                    i < text.length() &&
                            (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.')
            );

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public boolean isMatches(String s, String p) {
        return isMatch(s, p);
    }
//    public boolean isMatches(String s, String p) {
//        if (s.length() > 0 && p.length() > 0) {
//            boolean matched = true;
//            char prevPattern = '\u0000';
//            int i = 0, j = 0;
//            boolean st = false;
//            for (; i < s.length() && j < p.length(); ) {
//                char ch = s.charAt(i);
//                if(st && (ch == prevPattern || prevPattern == '.') ) {
//                    i++;
//                    continue;
//                } else {
//                    st = false;
//                }
//                char pt = p.charAt(j);
//                if (pt == '.') {
//                    i++;
//                    j++;
//                } else if (pt == '*') {
//                    st = true;
//                    j++;
//                    continue;
//                } else {
//                    if (ch == pt) {
//                        i++;
//                        j++;
//                    } else if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
//                        j++;
//                    } else {
//                        matched = false;
//                        break;
//                    }
//                }
//                prevPattern = pt;
//            }
//            return (i >= s.length()) && (j >= p.length()) && matched;
//        } else {
//            return false;
//        }
//    }
}
