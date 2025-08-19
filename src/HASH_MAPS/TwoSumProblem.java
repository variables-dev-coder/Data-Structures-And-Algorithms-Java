package HASH_MAPS;


/*

Problem 2: Two Sum (LeetCode #1)

Given an array of integers nums and an integer target, return the indices of the two
numbers such that they add up to target.

Example
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]   // because nums[0] + nums[1] = 2 + 7 = 9

Logic with HashMap

We need to find two numbers such that:
nums[i] + nums[j] = target

Instead of checking all pairs (O(n²)), we use a HashMap:
Store value → index in HashMap.
For each element nums[i]:
Compute complement = target - nums[i]
If complement already exists in map → we found the pair!
Otherwise, put nums[i] in the map.
This reduces time to O(n).
 */


import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // No solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}

/*
Dry Run

nums = [2, 7, 11, 15], target = 9

i=0 → num=2 → complement=7 → not in map → put {2=0}

i=1 → num=7 → complement=2 → found in map! (index=0)
Return [0, 1]

Output: [0, 1]

 */