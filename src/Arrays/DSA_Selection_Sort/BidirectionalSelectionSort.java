package Arrays.DSA_Selection_Sort;

import java.util.Arrays;

public class BidirectionalSelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minIdx = left, maxIdx = right;

            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[minIdx]) minIdx = i;
                if (arr[i] > arr[maxIdx]) maxIdx = i;
            }

            // Swap min to left
            int temp = arr[left];
            arr[left] = arr[minIdx];
            arr[minIdx] = temp;

            // Handle case where max was at left
            if (maxIdx == left) maxIdx = minIdx;

            // Swap max to right
            temp = arr[right];
            arr[right] = arr[maxIdx];
            arr[maxIdx] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
