package Arrays.Revision_Searching;


/*

Concept of Binary Search
Binary Search is a divide and conquer algorithm.
It only works on sorted arrays (ascending or descending).

Idea:
Find the middle element of the array.
If key == mid → return index.
If key < mid → search left half.
If key > mid → search right half.
Repeat until start > end → return -1 (not found).

Logic (Iterative Binary Search)
Initialize low = 0, high = n-1.
While low <= high:
mid = (low + high) / 2
If arr[mid] == key → return mid
If arr[mid] < key → search in right (low = mid+1)
Else → search in left (high = mid-1)
Return -1 if not found.

 */

public class BinarySearchIterative {
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid; // key found
            } else if (arr[mid] < key) {
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 7;
        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
