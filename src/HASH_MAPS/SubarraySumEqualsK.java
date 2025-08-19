package HASH_MAPS;

/*
Problem: Subarray Sum Equals K

Statement:
Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example:

Input: nums = [1,2,3], k = 3
Output: 2
Explanation: The subarrays are [1,2] and [3].

Approach using HashMap

Keep a prefix sum as we traverse.

Use a HashMap to store how many times each prefix sum has occurred.

At each index, check if (currentSum - k) exists in HashMap. If yes, add its frequency to the count.

 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Important: prefix sum 0 occurs once

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // Check if there is a prefixSum such that sum - prefixSum = k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update frequency of current sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Count of subarrays with sum " + k + " = " + subarraySum(nums, k));
    }
}

/*
Dry Run

nums = [1,2,3], k = 3

Start: prefixSumCount = {0=1}, sum=0, count=0

num=1 → sum=1 → check 1-3=-2 (not found) → add {1=1}

num=2 → sum=3 → check 3-3=0 (found, freq=1) → count=1 → add {3=1}

num=3 → sum=6 → check 6-3=3 (found, freq=1) → count=2 → add {6=1}

Result = 2
 */