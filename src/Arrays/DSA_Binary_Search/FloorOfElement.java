package Arrays.DSA_Binary_Search;



// Binary Search – Problem 4: Floor of an Element in Sorted Array

// Problem Statement:
//Given a sorted array and a target, return the floor of the target.
// The floor of a target is the greatest element smaller than or equal to the target.
//If the floor doesn’t exist (i.e., all elements are greater than the target), return -1.


public class FloorOfElement {

    public static int findFloor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int floor = - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];      // Exact match is also floor
            } else if (nums[mid] < target) {
                floor = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 11, 12, 19};
        int target = 9;
        System.out.println("Floor of " + target + " = " + findFloor(nums, target));

    }
}
