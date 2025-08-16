package Arrays.Revision_Sorts;

/*
Selection Sort — Concept

Idea:

Find the minimum element in the unsorted part of the array.
Swap it with the first element of the unsorted part.
Repeat until the array is sorted.

Think of it like selecting the smallest card from the deck and placing it in order.

Example

Array: [5, 3, 8, 4, 2]
Step 1: Find min from [5, 3, 8, 4, 2] → min = 2 → swap with 1st → [2, 3, 8, 4, 5]
Step 2: Find min from [3, 8, 4, 5] → min = 3 → already in place → [2, 3, 8, 4, 5]
Step 3: Find min from [8, 4, 5] → min = 4 → swap with 8 → [2, 3, 4, 8, 5]
Step 4: Find min from [8, 5] → min = 5 → swap → [2, 3, 4, 5, 8] Sorted

 */

public class SelectionSort_1 {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume the min is the first element
            int minIndex = i;

            // Finding the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// 2 3 4 5 8

/*
Complexity

Best Case → O(n²)
Worst Case → O(n²)
Space Complexity → O(1) (in-place)
Stability → Not stable (equal elements order may change)

 */