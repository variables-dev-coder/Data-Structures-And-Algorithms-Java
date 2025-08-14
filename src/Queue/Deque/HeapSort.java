package Queue.Deque;

// Implement Heap Sort using a Max Heap. The algorithm should sort an
// array in ascending order without using any built-in sorting functions.

//arr = [12, 11, 13, 5, 6, 7]
// [5, 6, 7, 11, 12, 13]

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap current root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    void heapify(int arr[], int n, int i) {
        int largest = i; // root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Test
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// Sorted array:
// 5 6 7 11 12 13

/*
Logic Explanation
1.Build a Max Heap from the given array.
    Max Heap means the largest element is at the root.
2.Extract elements from the heap one by one:
    Swap the root (largest element) with the last element in the heap.
    Reduce the heap size by one.
    Heapify the root element to restore the Max Heap property.
3.Repeat until the array is sorted.

Dry Run

Initial Array: [12, 11, 13, 5, 6, 7]
Step 1 — Build Max Heap:
[13, 11, 12, 5, 6, 7]
Step 2 — Swap max with last & heapify:
Swap 13 and 7 → [7, 11, 12, 5, 6, 13]
Heapify → [12, 11, 7, 5, 6, 13]
Step 3 — Repeat until sorted:
Final sorted array → [5, 6, 7, 11, 12, 13]

 */