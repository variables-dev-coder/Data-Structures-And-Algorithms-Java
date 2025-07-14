package Arrays.DSA_Selection_Sort;

public class SelectionSort_2 {
    public static void main(String[] args) {
        int[] arr = {78, 45, 12, 34, 78, 11, 90};

        // Print Original Array
        System.out.println("Original Array:");
        printArray(arr);

        // Selection Sort
        slectionSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // Selection Sort Implementing
    public static void slectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    // helper method to print arrays
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
