package Trees.Binary_Search_Tree_BST.revision;

public class BinarySearchExample {

    // Binary Search function
    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;              // target found
            } else if (arr[mid] < target) {
                low = mid + 1;           // search right half
            } else {
                high = mid - 1;          // search left half
            }
        }

        return -1; // target not found
    }

    // Main method (entry point)
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}

