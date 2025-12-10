package Revision.Day_6;

/*
Given an array of integers and a target value, return the indices of the two numbers such that
they add up to the target.
You may assume exactly one solution exists.

2. Algorithm (Step-by-step)

Brute Force Algorithm (O(n²))
    1.Loop i from 0 → n-1
    2.Loop j from i+1 → n-1
    3.If nums[i] + nums[j] == target, return [i, j].

Optimal Algorithm (Using HashMap, O(n))
    1.Create HashMap map
    2.For each element nums[i]:
       complement = target - nums[i]
       If complement exists in map → return indices
       Else put nums[i] in map with its index
    3.Guaranteed to find a solution.

 */


import java.util.*;

public class TwoSumOptimal {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // Should never reach here (one solution guaranteed)
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

// Indices: [0, 1]

/*

Dry Run (For nums = [2,7,11,15], target = 9)

Map = { }

i = 0 → nums[0] = 2

complement = 9 - 2 = 7
→ 7 NOT in map
Map = {2=0}

i = 1 → nums[1] = 7

complement = 9 - 7 = 2
→ 2 IS in map
→ return {map.get(2), 1} = {0, 1}

Output: [0, 1]

 */
