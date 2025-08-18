package DSA_Hash_Sets;

import java.util.HashSet;

/*
Given an array of integers, check if there exists a subarray (contiguous elements) whose sum is 0.

Example 1:
Input: [4, 2, -3, 1, 6]
Output: true   // Subarray [2, -3, 1] has sum 0

Example 2:
Input: [1, 2, 3]
Output: false   // No subarray with sum 0

Intuition
Keep track of the prefix sum while iterating through the array.
If the same prefix sum appears again → that means the subarray in between has sum = 0.
Also, if the prefix sum itself becomes 0, that means we found a subarray from start.
We use a HashSet to store prefix sums seen so far.

 */


public class SubarrayWithZeroSum {
    public static boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            // Case 1: prefixSum is 0
            if (prefixSum == 0) return true;

            // Case 2: prefixSum seen before
            if (set.contains(prefixSum)) return true;

            // Store prefixSum
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, -3, 1, 6};
        System.out.println(hasZeroSumSubarray(arr1)); // true

        int[] arr2 = {1, 2, 3};
        System.out.println(hasZeroSumSubarray(arr2)); // false
    }
}

/*
Dry Run (arr = [4, 2, -3, 1, 6])
prefixSum = 4 → set = {4}
prefixSum = 6 → set = {4, 6}
prefixSum = 3 → set = {4, 6, 3}
prefixSum = 4 → already in set → subarray with sum 0 exists

 */