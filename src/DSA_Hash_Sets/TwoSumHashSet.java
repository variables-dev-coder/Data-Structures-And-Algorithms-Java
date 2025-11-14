package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class TwoSumHashSet {
    /**
     * Problem: Find two numbers that add up to target
     * Concept: Use HashSet to store seen numbers and check for complement
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            // If we've seen the complement before, we found our pair
            if (seen.contains(complement)) {
                return new int[]{complement, num};
            }

            // Add current number to seen set
            seen.add(num);
        }

        return new int[0]; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println("Two Sum Problem:");
        System.out.println("Input: " + java.util.Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Output: " + java.util.Arrays.toString(result));
        System.out.println("Concept: Complement lookup using HashSet for O(1) search");
        System.out.println();
    }
}


/*

Two Sum Problem:
Input: [2, 7, 11, 15], Target: 9
Output: [2, 7]
Concept: Complement lookup using HashSet for O(1) search


Key Concept: Instead of nested loops (O(n²)), we use HashSet for O(1)
lookups to find if the complement (target - current) exists.

 */