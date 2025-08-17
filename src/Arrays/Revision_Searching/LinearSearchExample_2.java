package Arrays.Revision_Searching;

public class LinearSearchExample_2 {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;   // return index where key is found
            }
        }

        return -1;  // key not found
    }

    public static void main(String[] args) {
        int[] arr = {34, 56, 12, 78, 10, 31, 99};
        int key = 10;

        int result = linearSearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

// Element found at index: 2


/*

What is Linear Search?

Linear Search is the simplest searching algorithm where we sequentially check
each element of the array until the desired element (key) is found or we reach the end of the array.

Characteristics
Works on both sorted and unsorted arrays.

Time Complexity:
Best Case → O(1) (first element is the key)
Worst Case → O(n) (last element or not present)

Space Complexity: O(1)
Algorithm
Start from index 0.
Compare each element with the target.
If match found → return index.
If loop ends without finding → return -1 (not found).


 */