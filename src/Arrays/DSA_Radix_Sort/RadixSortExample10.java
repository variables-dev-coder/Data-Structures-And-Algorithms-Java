package Arrays.DSA_Radix_Sort;


// Array with Numbers of Varying Lengths
// [7, 45, 1, 1234, 56, 789, 23, 5]
// [1, 5, 7, 23, 45, 56, 789, 1234]


public class RadixSortExample10 {

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

        // Count digit occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Accumulate counts
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 45, 1, 1234, 56, 789, 23, 5};

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
