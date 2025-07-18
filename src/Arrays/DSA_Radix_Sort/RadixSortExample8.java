package Arrays.DSA_Radix_Sort;


// Numbers with Different Digit Lengths
// [1, 10, 100, 1000, 10000, 100000, 2, 20, 200, 2000]
// [1, 2, 10, 20, 100, 200, 1000, 2000, 10000, 100000]

public class RadixSortExample8 {

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr)
            if (i > max)
                max = i;
        return max;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of digits at current position
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Accumulate count values
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in stable order
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 100, 1000, 10000, 100000, 2, 20, 200, 2000};

        System.out.println("Before Sorting:");
        printArray(arr);

        radixSort(arr);

        System.out.println("After Radix Sort:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
