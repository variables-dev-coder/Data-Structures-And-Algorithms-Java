package Arrays.DSA_Radix_Sort;




// Reverse Sorted Input

// [1000, 900, 800, 700, 600, 500, 400, 300, 200, 100]

// [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000]


public class RadixSortExample7 {

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for every digit.
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

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Convert count to actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array from right to left (stable sort)
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
        int[] arr = {1000, 900, 800, 700, 600, 500, 400, 300, 200, 100};

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
