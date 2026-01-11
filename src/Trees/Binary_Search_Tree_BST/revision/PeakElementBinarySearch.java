package Trees.Binary_Search_Tree_BST.revision;

public class PeakElementBinarySearch {

    // Function to find peak element index
    public static int findPeakElement(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;   // move right
            } else {
                high = mid;      // move left
            }
        }

        return low; // peak index
    }

    // Main method
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}

