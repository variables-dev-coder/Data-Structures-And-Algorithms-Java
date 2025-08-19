package HASH_MAPS;

/*
Problem: Longest Subarray with Given Sum

Given an array of integers and a sum k, find the length of the longest subarray whose sum is equal to k.

Example
Input:  arr = [10, 5, 2, 7, 1, 9], k = 15
Output: 4   // Subarray [5, 2, 7, 1] has sum = 15

Logic with HashMap (Prefix Sum Method)

Maintain a prefix sum while traversing the array.
prefixSum[i] = sum of elements from 0 to i
We want subarray sum = k →
prefixSum[j] - prefixSum[i] = k
⇒ prefixSum[i] = prefixSum[j] - k
Use a HashMap to store the first occurrence of a prefixSum.
Key → prefixSum
Value → index
While traversing:
If prefixSum == k, update longest length.
If (prefixSum - k) exists in map → we found a subarray.
Update max length.

Time Complexity → O(n)
Space Complexity → O(n)
 */


import java.util.HashMap;

public class LongestSubarraySum {
    public static int longestSubarrayWithSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: Subarray from start
            if (sum == k) {
                maxLen = i + 1;
            }

            // Case 2: If (sum - k) seen before
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store first occurrence of sum
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(longestSubarrayWithSum(arr, k)); // 4
    }
}

/*
Dry Run

arr = [10, 5, 2, 7, 1, 9], k = 15
i=0 → sum=10 → not equal to 15 → store {10=0}
i=1 → sum=15 → maxLen=2
i=2 → sum=17 → check 17-15=2 (not in map) → store {17=2}
i=3 → sum=24 → check 24-15=9 (not in map) → store {24=3}
i=4 → sum=25 → check 25-15=10 → found at index=0 → subarray length=4 → maxLen=4
i=5 → sum=34 → check 34-15=19 (not in map) → store {34=5}

Answer = 4
 */