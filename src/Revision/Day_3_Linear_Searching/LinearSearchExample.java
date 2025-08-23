package Revision.Day_3_Linear_Searching;

public class LinearSearchExample {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;        // return index if found
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int target = 40;

        int result = linearSearch(nums, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);  // 3
        }
    }
}
