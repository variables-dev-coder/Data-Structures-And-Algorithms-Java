package Arrays.DSA_Binary_Search;

public class InfiniteArraySearch {

    // Simulate infinite array using interface

    static int getElement(int[] arr, int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;  // Simulating infinity
        return arr[index];
    }

    public static int searchInfinite(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // step 1: Find range
        while (getElement(arr, end) < target) {
            int newStart = end;
            end = end * 2;
            start = newStart;
        }

        // step 2: Binary Search in found range
        return binarySearch(arr, start, end, target);
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value  = getElement(arr, mid);

            if (value == target)
                return mid;
            else if (value > target) end = mid - 1;
            else start = mid + 1;
        }
        return - 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 10, 13, 15, 17, 18, 20, 21, 25, 27, 30};
        int target = 15;

        int result = searchInfinite(arr, target);
        System.out.println("Index of " + target + " : " + result);
    }
}
