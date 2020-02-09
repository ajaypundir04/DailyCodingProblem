package demo.code.leetcode;

public class StringSubstring {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() % 2 !=0 ) {
            return false;
        }

        int mid = s.length() / 2;
        boolean found = true;
        while(mid > 1 ) {
            String prefix = s.substring(0, mid);
            int pl = prefix.length();
            int i = pl;
            found = true;
            for(; i < s.length(); i+= pl) {
                int j = i;
                for(char c : prefix.toCharArray()) {
                    if(j >= s.length() || s.charAt(j) != c){
                        found = false;
                        break;
                    }
                    j++;
                }
                if(!found) {
                    break;
                } else {
                    return found;
                }
            }
            mid = mid / 2;
        }

        return found;
    }
}
