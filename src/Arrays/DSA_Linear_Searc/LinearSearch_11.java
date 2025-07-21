package Arrays.DSA_Linear_Searc;


// Linear Search Using Recursion

// Implement linear search using recursion to find the index of a target element. If not found, return -1.

public class LinearSearch_11 {
    public static int recursiveSearch(int[] arr, int target, int index) {
        // Base case: End of array
        if (index == arr.length) {
            return index;
        }

        // If element matches
        if (arr[index] == target) {
            return index;
        }

        // Recursive call
        return recursiveSearch(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 2, 4};
        int target = 9;

        int index = recursiveSearch(arr, target, 0);

        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found!");
    }
}
