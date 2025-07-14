package Arrays.DSA_Selection_Sort;

import java.util.Arrays;

public class EarlyTerminationSelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};   // Already sorted

        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }
            if (!swapped)
                break;     // Early exit is no swapps

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}


// Optimized to exit early if array is already sorted