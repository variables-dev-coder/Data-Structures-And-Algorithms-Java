package Arrays.Revision_Sorts;

/*
Merge Sort — Concept

Divide & Conquer Algorithm

Divide the array into two halves.
Conquer → sort each half recursively.
Combine → merge the two sorted halves.
Works like splitting paper in half until single numbers, then merging them back in sorted order.

🔹 Example
Array: [5, 3, 8, 4, 2]
Step 1: Divide → Split into halves until single elements
[5, 3, 8] and [4, 2]
Further split → [5] [3, 8] and [4] [2]
[3, 8] → [3] [8]
Now we have: [5] [3] [8] [4] [2]
Step 2: Conquer & Merge
Merge [3] [8] → [3, 8]
Merge [5] [3, 8] → [3, 5, 8]
Merge [4] [2] → [2, 4]
Finally merge [3, 5, 8] [2, 4] → [2, 3, 4, 5, 8] Sorted

 */



public class MergeSort_1 {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Divide
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Conquer (merge)
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        // Merge process
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

//2 3 4 5 8

/*
Complexity

Best Case: O(n log n)
Worst Case: O(n log n)
Space Complexity: O(n) (extra temp arrays needed)

Stable:Yes
 */