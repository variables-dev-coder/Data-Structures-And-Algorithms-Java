package Arrays.Revision_Sorts;

/*
Heap Sort — Concept

Heap Sort is based on the Binary Heap data structure (usually Max-Heap).
Steps:

Build a Max Heap from the array.
The largest element is at the root → swap it with the last element.
Reduce heap size → heapify again to maintain heap property.
Repeat until array is sorted.

Think of it like repeatedly pulling the highest priority element out of a priority queue.

Example

Array: [4, 10, 3, 5, 1]
Step 1: Build Max Heap → [10, 5, 3, 4, 1]
Step 2: Swap root with last → [1, 5, 3, 4, 10]
Heapify [1, 5, 3, 4] → [5, 4, 3, 1, 10]
Step 3: Swap root with last → [1, 4, 3, 5, 10]
Heapify [1, 4, 3] → [4, 1, 3, 5, 10]
Step 4: Swap root with last → [3, 1, 4, 5, 10]
Heapify [3, 1] → [3, 1, 4, 5, 10]
Step 5: Swap root with last → [1, 3, 4, 5, 10] Sorted
 */


public class HeapSort_1 {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;   // root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // if left child is greater
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // if right child is greater
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if root is not largest, swap and heapify
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
Complexity

Best Case: O(n log n)
Worst Case: O(n log n)
Space Complexity: O(1) (in-place)
Stability: Not stable

 */