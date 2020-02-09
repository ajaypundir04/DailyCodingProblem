package demo.code.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxDiff {

    public static void main(String[] args) {
//        System.out.println(new MaxDiff().maxProfit(
//          new int[] {7, 6, 3, 2, 1, 4}
//        )
//        );
//
//        List<Integer> st = new ArrayList<>();
//        st.add(0, 2);
//        st.add(1, 3);
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean correct = true;
        char[] ch = s.toCharArray();
        for(char c : ch) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char stored = stack.pop();
                if(c == ')' && stored != '(') {
                    correct= false;
                    break;
                } else if (c == '}' && stored != '{') {
                    correct = false;
                    break;
                } else if(stored != '[') {
                    correct = false;
                    break;
                }
            }
        }

        return correct ;
    }

    public int maxProfit(int[] a) {
        int max_diff = 0;
        if(a.length == 0)
            return 0;
        int min= a[0];
        for(int i = 0; i< a.length;i++) {
            if(a[i]<min) {
                min = a[i];
            }
            int j = a[i]-min;
            if(j >max_diff) {
                max_diff = j;
            }
        }
        return max_diff;
    }
}
