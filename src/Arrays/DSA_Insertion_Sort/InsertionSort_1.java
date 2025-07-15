package Arrays.DSA_Insertion_Sort;

public class InsertionSort_1 {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element index
        for (int i = 1; i < n; i++) {
            int key = arr[i];        // Current element to be inserted
            int j = i - 1;           // Start comparing with the previous element

            // Shift elements greater than 'key' to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];    // Move thge large element forward
                j--;
            }
            arr[j + 1] = key;   // Insert 'key' in its correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 1, 2};

        System.out.println("Original Array:");
        printArray(arr);

        insertionSort(arr);    // Sort the array

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
