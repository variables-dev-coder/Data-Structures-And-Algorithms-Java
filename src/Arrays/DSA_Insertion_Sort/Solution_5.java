package Arrays.DSA_Insertion_Sort;


import java.util.Arrays;

public class Solution_5 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Custom insertion sort
        for (int i = 1; i < strs.length; i++) {
            String key = strs[i];
            int j = i - 1;
            while (j >= 0 && (strs[j] + key).compareTo(key + strs[j]) < 0) {
                strs[j + 1] = strs[j];
                j--;
            }
            strs[j + 1] = key;
        }

        if (strs[0].equals("0")) return "0";
        return String.join("", strs);
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Largest Number: " + new Solution_5().largestNumber(nums));
    }
}
