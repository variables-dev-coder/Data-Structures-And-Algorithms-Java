package Arrays.Revision_Searching;

public class LinearSearchIndex {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;    // return index of first occurrence
            }
        }
        return -1;   // if not found
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 56, 78, 70, 23, 34};
        int key = 34;

        int index = linearSearch(arr, key);

        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

/*
Logic Explanation:
Traverse array from left to right.
Compare each element with key.
If match found → return index immediately (first occurrence).
If loop ends without match → return -1.
 */