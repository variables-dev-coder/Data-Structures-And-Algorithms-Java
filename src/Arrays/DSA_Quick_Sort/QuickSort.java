package Arrays.DSA_Quick_Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[]  arr = {7, 2, 1, 6, 8, 5, 3, 4};
        QuickSort(arr, 0, arr.length -1);

        System.out.println("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);          // Find pivot position
            QuickSort(arr, low, partitionIndex - 1);            // sort left sub array
            QuickSort(arr, partitionIndex + 1, high);            // sort right sub array

        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];          // choose pivot (last element)
        int i = low - 1;                // i points to the last element smaller than pivot

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with element at i + 1 to put pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;      // return the partition index
    }
}
