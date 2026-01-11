package Trees.Binary_Search_Tree_BST.revision;

public class LastOccurrenceBinarySearch {

    // Function to find last occurrence
    public static int lastOccurrence(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;        // store answer
                low = mid + 1;       // move right to find last occurrence
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

        int index = lastOccurrence(arr, target);

        if (index != -1) {
            System.out.println("Last occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println("Target not found");
        }
    }
}

