package Arrays.DSA_Binary_Search;

public class RotationCount {

    public static int findRotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Case when subarray is already sorted
            if (arr[start] <= arr[end]) return start;

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;

            // Check if mid is the minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Left half is sorted -> go right
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            }
            // right half is sorted -> go left
            else {
                end = mid - 1;
            }
        }
        return 0;   // If not rotated
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotationCount = findRotationCount(arr);
        System.out.println("Array is rotated " + rotationCount + " times.");
    }
}
