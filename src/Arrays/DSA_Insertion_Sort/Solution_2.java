package Arrays.DSA_Insertion_Sort;

import java.util.Arrays;

public class Solution_2 {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        int[] sorted = new Solution_2().sortArray(nums);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(sorted));
    }
}
