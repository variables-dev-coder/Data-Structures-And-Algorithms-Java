package Arrays.DSA_Radix_Sort;

public class RadixSortExample {

    // Main Radix sort function

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for every digit (unit, tens, hundreds...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // get maximum value in the array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }

    // Counting sort based on digit represented by exp (1, 10, 100, etc)
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];    // output array
        int[] count = new int[10];    // for digits 0 to 9

        // Count occurrences
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // Convert count[] to positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // copy output[] to array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


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
