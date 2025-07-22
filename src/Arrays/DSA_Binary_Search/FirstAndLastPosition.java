package Arrays.DSA_Binary_Search;



// Find First and Last Position of Element in Sorted Array
// Given a sorted array of integers nums, find the first and last position of a given target value.
//If the target is not found, return [-1, -1].


public class FirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);        // Find First Occurrence
        int last = findIndex(nums, target, false);        // Find last Occurrence
        return new int[] {first, last};
    }

    private static int findIndex(int[] nums, int target, boolean findFirst) {
        int start =0;
        int end = nums.length;
        int result = - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    end = mid - 1;        // Go left to find first occurrence
                } else {
                    start = mid + 1;      // Go right to find last occurrence
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};

       // int target = 8;   // First and Last Position: [3, 4]

        int target = 6;     // First and Last Position: [-1, -1]

        int[] result = searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }
}
