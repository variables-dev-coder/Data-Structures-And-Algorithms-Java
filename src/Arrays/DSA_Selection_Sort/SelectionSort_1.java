package Arrays.DSA_Selection_Sort;

public class SelectionSort_1 {
    public static void main(String[] args) {
        int[] array = {64, 34, 55, 13, 7, 9, 33, 90};
        int n = array.length;

        for (int i = 0; i < n; i++) {             // Outer loop
            int min_index = i;                    // Assume current element is smallest
            for (int j = i + 1; j < n; j++) {     // Inner loop to find actual minimum
                if (array[j] < array[min_index]) {   // Update min_index if smaller found
                    min_index = j;
                }
            }
            // Swap elements
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }

        // Print sorted array
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
