package demo.code.google;

public class MaxArea {

    public static void main(String[] args) {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    public static int maxArea(int[] height) {
        int max = 0, l = height.length;
        int i = 0, j = l - 1;

        while (i < j) {
            int a = height[i];
            int b = height[j];
            int tmp = Math.abs(i - j);
            int min = Math.min(a, b);
            max = Math.max((tmp * min), max);
            if (a < b) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
