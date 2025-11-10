package Practices.Week_1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Brute force approach - O(n^2)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return  new int[]{i, j};
                }
            }
        }
        throw  new IllegalArgumentException("No two sum solution");
    }

    // Optimized approach using HashMap - O(n)
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result1 = twoSumBruteForce(nums, target);
        System.out.println("Brute force result: [" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = twoSumOptimized(nums, target);
        System.out.println("Optimized result: [" + result2[0] + ", " + result2[1] + "]");

        // Test with different input
        //int[] nums2 = {3, 2, 4};
        //int target2 = 6;
        //int[] result3 = twoSumOptimized(nums2, target2);
       // System.out.println("Test case 2: [" + result3[0] + ", " + result3[1] + "]");
    }
}

//Brute force result: [0, 1]
//Optimized result: [0, 1]