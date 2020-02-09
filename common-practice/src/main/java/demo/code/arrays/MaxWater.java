package demo.code.arrays;

public class MaxWater {

    public static void main(String[] args) {
        int[] ar =
                new int[]{
//                2, 3, 10, 2, 4, 8, 1
                        7, 2, 3, 10, 2, 4, 8, 1
                };
//        System.out.println(maxWater(ar));
//        System.out.println(maxDiff(ar, ar.length));
//        System.out.println(maxDiff1(ar, ar.length));
        System.out.println(maxDiff2(ar, ar.length));
    }

    static int maxWater(int[] ar) {
        return maxW(ar, 0);
    }

    static int maxW(int[] ar, int start) {
        int max = Integer.MIN_VALUE;
        if (start >= ar.length) {
            return max;
        }
        for (int i = start + 1; i < ar.length; i++) {
            max = Math.max(max, ar[i] - ar[start]);
        }
        return Math.max(max, maxW(ar, start + 1));
    }

    static int maxDiff(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    static int maxDiff1(int arr[], int n) {
        // Create a diff array of size n-1.
        // The array will hold the difference
        // of adjacent elements
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i] = arr[i + 1] - arr[i];

        // Now find the maximum sum
        // subarray in diff array
        int max_diff = diff[0];
        for (int i = 1; i < n - 1; i++) {
            if (diff[i - 1] > 0)
                diff[i] += diff[i - 1];
            if (max_diff < diff[i])
                max_diff = diff[i];
        }
        return max_diff;
    }

    static int maxDiff2(int arr[], int n) {
        // Initialize diff, current
        // sum and max sum
        int diff = arr[1] - arr[0];
        int curr_sum = diff;
        int max_sum = curr_sum;

        for (int i = 1; i < n - 1; i++) {
            // Calculate current diff
            diff = arr[i + 1] - arr[i];

            // Calculate current sum
            if (curr_sum > 0)
                curr_sum += diff;
            else
                curr_sum = diff;

            // Update max sum, if needed
            if (curr_sum > max_sum)
                max_sum = curr_sum;
        }

        return max_sum;
    }
}
