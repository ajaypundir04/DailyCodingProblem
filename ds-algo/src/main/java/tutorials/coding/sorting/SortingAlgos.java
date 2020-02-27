package tutorials.coding.sorting;

public class SortingAlgos {

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > k) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = k;
        }
    }
}
