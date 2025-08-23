package Revision.Day_3_Binary_Searching;

public class BinarySearchExample {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45};
        int target = 35;

        int index = binarySearch(arr, target);
        if (index != -1)
            System.out.println("Found at index: " + index);
        else
            System.out.println("Not Found");
    }
}
