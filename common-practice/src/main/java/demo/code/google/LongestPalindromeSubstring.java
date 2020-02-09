package demo.code.google;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        System.out.println(l.longestPalindrome("abcba"));
    }

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int length = ch.length;
        String answer = "";
        for(int i = 0; i < length; i++) {
            String tmp = palindromeLength(ch, i, i);
            String tmp1 = palindromeLength(ch, i, i+1);
            if(tmp.length() > answer.length()) {
                answer = tmp;
            }

            if(tmp1.length() > answer.length()) {
                answer = tmp1;
            }
        }
        return answer;
    }

    private String palindromeLength(char[] ch, int iIndex, int jIndex) {
        String left = "", right = "";
        for(int i = iIndex, j = jIndex; i >= 0 && j < ch.length; i--,j++ ) {
            if(ch[i] == ch[j]) {
                if(i!=j) {
                    left = ch[i]+left;
                    right =ch[j]+right;
                }
            } else {
                break;
            }
        }
        return left + (iIndex == jIndex ? ch[iIndex]:"") + right;
    }
}
