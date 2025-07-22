package Arrays.DSA_Binary_Search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;   // To avoid overflow

            if (arr[mid] == target) {
                return mid;          // Found
            } else if (arr[mid] < target) {
                start = mid + 1;    // Right half
            } else {
                end = mid - 1;      // Left half
            }
        }
        return - 1;    // Not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56};
        int target = 16;

        int result = binarySearch(arr, target);
        System.out.println(result != - 1 ? "Element found at index: " + result : "Element not found!");
    }
}
