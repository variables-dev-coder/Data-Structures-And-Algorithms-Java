package Trees.Binary_Search_Tree_BST.revision;

public class FindMinInRotatedArray {

    public static int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;   // minimum on right side
            } else {
                high = mid;      // minimum on left side
            }
        }

        return nums[low];
    }

    // Main method
    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int min = findMin(nums);

        System.out.println("Minimum element is: " + min);
    }
}

