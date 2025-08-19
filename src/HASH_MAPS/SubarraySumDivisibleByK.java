package HASH_MAPS;

/*
Problem: Subarray Sum Divisible by K

Given an array arr and an integer k, check if the array has a subarray of length ≥ 2 whose sum is divisible by k.

Example
Input:  arr = [23, 2, 4, 6, 7], k = 6
Output: true   // because subarray [2, 4] has sum = 6 (divisible by 6)
Input:  arr = [23, 2, 6, 4, 7], k = 6
Output: true   // because [23, 2, 6, 4, 7] → sum=42 divisible by 6
Input:  arr = [1, 2, 3], k = 5
Output: false

Logic with HashMap (Prefix Sum + Remainder)
Use prefix sum remainder concept:
If two prefix sums have the same remainder when divided by k,
then the subarray between them is divisible by k.
Example:
If prefixSum[i] % k = r and prefixSum[j] % k = r →
then (prefixSum[j] - prefixSum[i]) % k = 0.
Use a HashMap:
Key → remainder
Value → first index where remainder appeared.
While traversing:
Compute sum % k.
If remainder already seen and subarray length ≥ 2 → return true.
Otherwise, store remainder with index.
 */


import java.util.HashMap;

public class SubarraySumDivisibleByK {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Important: remainder 0 at index -1 for edge cases

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (rem < 0) rem += k; // handle negative numbers

            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(checkSubarraySum(arr1, k1)); // true

        int[] arr2 = {1, 2, 3};
        int k2 = 5;
        System.out.println(checkSubarraySum(arr2, k2)); // false
    }
}

/*
Dry Run

arr = [23, 2, 4, 6, 7], k=6

i=0 → sum=23 → rem=5 → store {5=0}

i=1 → sum=25 → rem=1 → store {5=0, 1=1}

i=2 → sum=29 → rem=5 → already exists at index=0 → length=2 → ✅ return true

Output: true
 */