package Revision.Day_3_Binary_Searching;

public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, low, mid - 1, target);
        else return binarySearch(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 25, 35, 45, 55};
        int target = 25;

        int result = binarySearch(arr, 0, arr.length - 1, target);

        if (result == -1) System.out.println("Element not found");
        else System.out.println("Element found at index: " + result);
    }
}
