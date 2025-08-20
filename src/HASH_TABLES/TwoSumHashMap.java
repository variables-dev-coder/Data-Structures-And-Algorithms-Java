package HASH_TABLES;

/*
Find Two Sum using HashMap
Problem:
Given an array of integers and a target value, find the indices of two numbers that add up to the target.
Logic:
Traverse the array.
For each element, check if (target - element) exists in the HashMap.
If yes → return indices.
If no → put the current number into the HashMap with its index.
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }

            map.put(nums[i], i);
        }
        return new int[]{}; // no solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}

// Indices: [0, 1]