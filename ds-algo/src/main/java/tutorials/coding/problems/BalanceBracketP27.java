package tutorials.coding.problems;

import java.util.Stack;

public class BalanceBracketP27 {

    public boolean bracketBalance(String str) {
        int s = 0, m = 0, l = 0;
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    s++;
                    continue;
                case '{':
                    m++;
                    continue;
                case '[':
                    l++;
                    continue;
                case ')':
                    if (s == 0) {
                        return false;
                    }
                    s--;
                    continue;
                case '}':
                    if (m == 0) {
                        return false;
                    }
                    m--;
                    continue;
                case ']':
                    if (l == 0) {
                        return false;
                    }
                    l--;
            }
        }
        return (s == 0 && m == 0 && l == 0);
    }

    public boolean bracketBalance1(String str) {
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                char pb = stk.pop();
                if(c == ')' && pb != '(') {
                    return false;
                } else if(c == '}' && pb != '{') {
                    return false;
                } else if(c == ']' && pb != '[') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
