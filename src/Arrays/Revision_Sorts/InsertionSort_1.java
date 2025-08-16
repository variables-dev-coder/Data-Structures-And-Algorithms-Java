package Arrays.Revision_Sorts;

/*
Insertion Sort — Concept

Idea:
Build the sorted array one element at a time.
Take each element and insert it into its correct position among the already sorted part.

Think of how you sort playing cards in your hand → you pick the next card and insert it into the right place.

🔹 Example

Array: [5, 3, 8, 4, 2]
Step 1: Start with first element [5] (already sorted).
Step 2: Take 3 → insert before 5 → [3, 5, 8, 4, 2]
Step 3: Take 8 → correct place after 5 → [3, 5, 8, 4, 2]
Step 4: Take 4 → insert between 3 and 5 → [3, 4, 5, 8, 2]
Step 5: Take 2 → insert at beginning → [2, 3, 4, 5, 8] Sorted

 */


public class InsertionSort_1 {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];   // current element to insert
            int j = i - 1;

            // shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // place the key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// 2 3 4 5 8

/*
Complexity

Best Case (already sorted) → O(n)
Worst Case → O(n²)
Space → O(1) (in-place)
Stability → Stabl

 */

