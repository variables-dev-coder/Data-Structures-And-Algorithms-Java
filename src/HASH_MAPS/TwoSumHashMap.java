package HASH_MAPS;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    /**
     * Problem: Find indices of two numbers that add up to target
     * Concept: Use HashMap to store number->index mapping for O(1) complement lookup
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            // Store current number and its index
            numMap.put(nums[i], i);
        }

        return new int[0]; // No solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println("=== Two Sum with HashMap ===");
        System.out.println("Input: " + java.util.Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        System.out.println("Concept: Store number->index mapping for O(1) complement lookup");
        System.out.println();
    }
}

/*
=== Two Sum with HashMap ===
Input: [2, 7, 11, 15], Target: 9
Output: [0, 1]
Concept: Store number->index mapping for O(1) complement lookup

Two Sum (HashMap Version)
Concept Used: Complement Lookup with HashMap storing indices

Key Concept: HashMap stores number->index mapping, allowing us to find the complement's index in O(1) time.
 */