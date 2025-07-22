package Arrays.DSA_Binary_Search;

public class CeilingOfElement {

    public static int findCeiling(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ceiling = - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];         // Exact match is also ceiling
            } else if (nums[mid] > target) {
                ceiling = nums[mid];  // Potential ceiling
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceiling;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 11, 12, 19};
        int target = 3;
        System.out.println("Ceiling of " + target + " = " + findCeiling(nums, target));
    }
}
