package Arrays.Revision_Sorts;

/*
Quick Sort — Concept

Divide & Conquer (like Merge Sort) but works differently:
Pick a pivot element (commonly first, last, or middle).
Partition the array → put smaller elements on the left, larger on the right.
Recursively apply quicksort to left and right partitions.
Works like organizing books around one chosen book (pivot): all smaller on left, larger on right.

🔹 Example

Array: [5, 3, 8, 4, 2]
Step 1: Choose pivot = 2 (last element).
Partition → [2, 3, 8, 4, 5] (2 in correct position).
Step 2: Left = [], Right = [3, 8, 4, 5]
Step 3: On [3, 8, 4, 5], pivot = 5.
Partition → [3, 4, 5, 8]
Step 4: Left = [3, 4], Right = [8]
Step 5: On [3, 4], pivot = 4.
Partition → [3, 4]
Final sorted array → [2, 3, 4, 5, 8]

 */


public class QuickSort_1 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort left and right partitions
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // pivot element
        int i = low - 1;        // smaller element index

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // pivot index
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*

Complexity
Best Case (balanced pivot): O(n log n)
Average Case: O(n log n)
Worst Case (bad pivot, sorted array): O(n²)
Space Complexity: O(log n) (recursive stack)

Stability: No

 */