package Arrays.Revision_Sorts;


/*
Radix Sort (Non-Comparative Sorting)
Concept
-Radix Sort works by sorting numbers digit by digit starting from the least significant digit (LSD)
 to the most significant digit (MSD).
-It uses a stable sorting algorithm like Counting Sort as a subroutine for sorting digits.
-Works best for integers or strings of fixed length.

How It Works

Let’s say we want to sort the array:
[170, 45, 75, 90, 802, 24, 2, 66]

Step 1: Sort by 1s place (units digit)
Group numbers by their last digit using counting sort.
After sorting by units digit → [170, 90, 802, 2, 24, 45, 75, 66]
Step 2: Sort by 10s place (tens digit)
Sort based on the second last digit.
Result → [802, 2, 24, 45, 66, 170, 75, 90]
Step 3: Sort by 100s place (hundreds digit)
Now sort based on hundreds digit.
Final sorted result → [2, 24, 45, 66, 75, 90, 170, 802]

Key Points

Time Complexity:
O(d * (n + k)) where
d = number of digits
n = number of elements
k = range of digits (0–9 for decimal numbers)
Space Complexity: O(n + k)
Stable: Yes
Not comparison-based like Quick or Merge.
 */


import java.util.Arrays;

public class RadixSort_1 {
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy back
        System.arraycopy(output, 0, arr, 0, n);
    }

    static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Sort each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

// Sorted array: [2, 24, 45, 66, 75, 90, 170, 802]