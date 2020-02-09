package demo.code.google;

public class AtoI {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("0-1"));
//        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        int number = 0;
        int signed = 1;
        boolean bitSet = false;
        for(int i = 0; i < str.length(); i++) {
            // if not digit
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                int tmp = ch - 48;
                if(number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && tmp > 7)) {
                    return Integer.MAX_VALUE;
                } else if(number < Integer.MIN_VALUE / 10 || (number == Integer.MIN_VALUE / 10 && tmp > 8)) {
                    return Integer.MIN_VALUE;
                } else {
                    number = (number * 10) + (signed * tmp);
                }

            } else if(ch == '-' || ch=='+') {
                if(!bitSet) {
                    if(number > 0) {
                        break;
                    } else {
                        signed = (ch == '-') ? -1 : 1;
                    }
                }else{
                    break;
                }

            } else {
                break;
            }
            bitSet=true;
        }
        return number;
    }
}
