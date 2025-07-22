package Arrays.DSA_Binary_Search;

public class NearlySortedBinarySearch {

    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check mid
            if (arr[mid] == target)
                return mid;

            // Check mid-1
            if (mid - 1 >= start && arr[mid - 1] == target)
                return mid - 1;

            // Now adjust search space
            if (target < arr[mid]) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }

        return - 1; // Not form
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;
        int result = search(arr, target);
        System.out.println("Index of " + target + " : " + result);
    }
}
