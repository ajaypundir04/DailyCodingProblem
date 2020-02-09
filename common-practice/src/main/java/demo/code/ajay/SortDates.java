package demo.code.ajay;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortDates {

    public static void main(String[] args) {
        List<String> dates = Arrays.asList(
                "01 Mar 2017",
                "03 Feb 2017",
                "15 Jan 1998"
        );
        System.out.println(dates);
        System.out.println(
                sort(dates)
        );

        System.out.println(
                new SortDates().find(
                        List.of(2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 2)
                )
        );
    }

    static List<String> sort(List<String> dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dates.stream()
                .map(s -> LocalDate.parse(s, formatter))
                .sorted()
                .map(formatter::format)
                .collect(Collectors.toList());

    }


    public void find(int[] arrA) {
        //xor will the xor of two non repeating elements
        //we know that in a XOR b, any particular bit is set if that bit is set in either a or b
        //we can use this to divide the array elements into two groups where each group will be responsible
        // to get a and b
        int xor = arrA[0];
        for (int i = 1; i < arrA.length; i++) {
            xor ^= arrA[i];
        }
        //get the right most set bit
        int right_most_set_bit = xor & ~(xor - 1);

        //divide the array elements into 2 groups
        int a = 0, b = 0;
        for (int i = 0; i < arrA.length; i++) {
            int x = arrA[i];
            if ((x & right_most_set_bit) != 0)
                a ^= x;
            else
                b ^= x;
        }
        System.out.println("Non Repeating Elements are: " + a + " and " + b);
    }

    public List<Integer> find(List<Integer> nums) {
        Map map = nums
                .stream()
                .collect(Collectors.groupingBy(Function.identity()));

        return List.of(1, 2);
    }
}
