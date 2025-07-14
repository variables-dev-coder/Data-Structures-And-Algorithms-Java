package Arrays.DSA_Selection_Sort;

public class SelectionSortExample_1 {

    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = {64, 25, 12, 22, 11};

        System.out.println("Original Array: ");
        printArray(arrayToSort);

        selectionSort(arrayToSort);    // call the sorting method

        System.out.println("\nSorted array:");
        printArray(arrayToSort);
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
