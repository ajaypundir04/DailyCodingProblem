package demo.code.leetcode;

public class Bitwise {

    public int add(int a, int b) {
        int partial = 0, carry = -1;

        while (carry != 0) {
            partial = a ^ b;
            carry = (a & b) << 1;

            a = partial;
            b = carry;
        }

        return partial;
    }

    public int sub(int a, int b) {
        return add(a, add(~b, 1));
    }

    public int division(int dividend, int divisor) {
        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { // Check for signed bit
            negative = !negative;
            dividend = add(~dividend, 1);  // Negation
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = add(~divisor, 1);  // Negation
        }
        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            r = (divisor << i);
            // Left shift divisor until it's smaller than dividend
            if (r < Integer.MAX_VALUE && r >= 0) { // Avoid cases where comparison between long and int doesn't make sense
                if (r <= dividend) {
                    quotient |= (1 << i);
                    dividend = sub(dividend, (int) r);
                }
            }
        }
        if (negative) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }
}
