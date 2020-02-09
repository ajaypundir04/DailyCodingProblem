package demo.code.dynamicproblems;

public class UglyNumber {

    public int uglyNum(int n) {
        int series = 1;
        int count = 1, number = 0;
        while (count < n) {
            if (series % 2 == 0 || series % 3 == 0 || series % 5 == 0) {
                System.out.println(series);
                number = series;
                count++;
            }
            series++;
        }
        return number;
    }
}
