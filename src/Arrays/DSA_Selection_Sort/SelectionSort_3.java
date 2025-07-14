package Arrays.DSA_Selection_Sort;

public class SelectionSort_3 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};  // Test with duplicate values

        // Print Original Array
        System.out.println("Original Array:");
        printArray(arr);

        // Selection Sort
        selectionSort(arr);

        // Print Sorted Array
        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // selection sort implementation
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    // Helping method to print arrays
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
