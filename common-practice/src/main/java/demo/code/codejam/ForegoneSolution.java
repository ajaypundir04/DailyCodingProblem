package demo.code.codejam;

public class ForegoneSolution {

    public static void main(String[] args) {
        int totalTests = 3;
        int[] ar = new int[]{4, 934, 16};
        int i = 0;
        while( i < totalTests) {
            int amount = ar[i];
            String[] result = splitAmount(String.valueOf(amount));
            System.out.printf("Case #%d: %s %s\n", (i+1), result[0], result[1]);
            i += 1;
        }
    }

    static String[] splitAmount(String amount) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(char c : amount.toCharArray()) {
            if(c == '4') {
                a.append('2');
                b.append('2');
            } else {
                a.append(c);
                b.append('0');
            }
        }
        return new String[]{a.toString(), b.toString()};
    }

    static boolean containsDigit(int number, int digit) {
        boolean contains = false;
        while(number > 0) {
            int t = number % 10;
            if(t == digit) {
                contains = true;
                break;
            }
            number /= 10;
        }
        return contains;
    }
}
