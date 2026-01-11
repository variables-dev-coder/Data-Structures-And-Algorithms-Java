package Trees.Binary_Search_Tree_BST.revision;

public class CountOccurrencesBinarySearch {

    // First occurrence
    public static int firstOccurrence(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Last occurrence
    public static int lastOccurrence(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Count occurrences
    public static int countOccurrences(int[] arr, int target) {

        int first = firstOccurrence(arr, target);
        if (first == -1) return 0; // not found

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 8, 10};
        int target = 4;

        int count = countOccurrences(arr, target);

        System.out.println("Count of " + target + " = " + count);
    }
}

