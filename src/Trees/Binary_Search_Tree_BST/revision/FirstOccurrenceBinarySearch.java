package Trees.Binary_Search_Tree_BST.revision;

public class FirstOccurrenceBinarySearch {

    // Function to find first occurrence
    public static int firstOccurrence(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;        // store answer
                high = mid - 1;      // move left to find first occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 8, 10};
        int target = 4;

        int index = firstOccurrence(arr, target);

        if (index != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println("Target not found");
        }
    }
}

