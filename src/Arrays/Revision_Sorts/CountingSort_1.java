package Arrays.Revision_Sorts;


/*
Counting Sort — Concept

Unlike Bubble/Quick/Heap, this is a non-comparison based sorting.
It works well when:
Elements are integers
Elements are in a small range (0 to k)

Steps:
Find the maximum element k in the array.
Create a count array of size k+1 to store frequency of each number.
Modify count array to store cumulative counts (prefix sum).
Place elements into a new sorted array using the count array.
Think of it as counting how many times each number appears, then placing them in order.

🔹 Example
Array: [4, 2, 2, 8, 3, 3, 1]
Step 1: Find max = 8 → create count array size 9 (0–8).
Step 2: Count frequencies
Count = [0,1,2,1,1,0,0,0,1]
(Index = number, Value = frequency)
Step 3: Cumulative count
Count = [0,1,3,4,5,5,5,5,6,7]
Step 4: Place elements
→ [1,2,2,3,3,4,8] Sorted
 */



public class CountingSort_1 {
    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Count array
        int[] count = new int[max + 1];

        // Store frequency
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Reconstruct sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
Complexity

Best/Worst Case: O(n + k) (where k = max element)
Space Complexity: O(k) (extra count array)
Stability: Yes

 */