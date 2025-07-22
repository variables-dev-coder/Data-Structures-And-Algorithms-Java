package Arrays.DSA_Binary_Search;

public class CountOccurrencesBinarySearch {

    public static int countOccurrences(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        if (first == - 1) return 0;   // target not found
        int last = findIndex(nums, target, false);
        return last - first + 1;
    }

    private static int findIndex(int[] nums, int target, boolean findFirst) {
        int ans = - 1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (findFirst) end = mid - 1;    // Search left
                else start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 10, 10, 10, 10, 18, 20};

        int target = 10;

        int count = countOccurrences(nums, target);
        System.out.println("Total Occurrence of " + target + " = " + count);
    }
}
