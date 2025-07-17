package Arrays.DSA_Counting_Sort;

// Use Counting Sort to handle negative integers as well.

//Logic:
//Find the min and max values to determine range.
//Use offset to shift negative values to positive index range.

import java.util.Arrays;

public class CountingSortNegative {

    public static void main(String[] args) {
        int[] arr = { -5, -10, 0, -3, 8, 5, -1, 10 };

        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int num : arr) {
            count[num - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.out.println("Sorted Array: " + Arrays.toString(output));
    }
}
