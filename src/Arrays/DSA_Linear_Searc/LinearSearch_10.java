package Arrays.DSA_Linear_Searc;



// Linear Search in Reverse (Right to Left)
//Search for a target element in an array from the end using linear search.
// Return the index of its last occurrence.


public class LinearSearch_10 {
    public static int reverseLinearSearch(int[] arr, int target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;    // found from right
            }
        }
        return -1;   // not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10};
        int target = 7;

        int index = reverseLinearSearch(arr, target);

        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found!");
    }
}
