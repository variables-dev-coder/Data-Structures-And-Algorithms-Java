package Arrays.DSA_Radix_Sort;



// Duplicate Elements
// Input: [23, 45, 12, 23, 67, 45, 23]
// Output: [12, 23, 23, 23, 45, 45, 67]



public class RadixSortExample4 {

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Apply counting sort for every digit
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
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // For digits 0 to 9

        // Count frequency of each digit at current place
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // Convert count to position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output (Stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copy output to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 45, 12, 23, 67, 45, 23};

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
