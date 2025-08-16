package Arrays.Revision_Sorts;

public class CountingSort_2 {
    public static void countingSort(int arr[]) {
        int n = arr.length;

        // Find max element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Count array
        int count[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Prefix sum
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Output array
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

/*

Counting Sort Explanation

Type: Non-comparison-based sorting (unlike Bubble, Merge, Quick, etc.).
Idea: Instead of comparing elements, it counts the number of occurrences of each distinct element.
Best suited for: Small integer ranges (not good for large or negative ranges without modifications).

⚡ Steps of Counting Sort:
Find the maximum element in the array.
Create a count array where index = element value, and value = frequency.
Modify the count array so each index stores the sum of previous counts (prefix sum).
Place each element into the correct sorted position using the count array.

Example

Array: [4, 2, 2, 8, 3, 3, 1]

Max element = 8 → count array size = 9 (0–8).
Count occurrences:
Count: [0,1,2,1,1,0,0,0,1]
Prefix sum (cumulative counts):
Count: [0,1,3,4,5,5,5,5,6]
Build output array (stable sort):
Result: [1,2,2,3,3,4,8]

 */