package Practices.Week_4;

/*
Array + HashMap Problem
-----------------------
Subarray Sum Equals K

(VERY IMPORTANT — asked in Google, Amazon, Microsoft)

Given an array arr[] and an integer k, find the total number of subarrays whose sum is exactly k.

Example

arr = [1, 2, 3], k = 3
Subarrays = [1,2], [3]
Output = 2

Why HashMap?

We use:
prefix sum and HashMap to store frequency of prefix sums

Formula:
If

prefixSum[j] - prefixSum[i] = k
→ subarray(i+1 ... j) has sum k

Algorithm (O(n))

1.Use map to store frequency of prefix sums
2.Initialize:
    map.put(0, 1) → one way to form sum = k from start
3.Maintain running sum
4.For each element
    desired = sum - k
    if desired exists → add frequency to count
5.Update map with new prefix sum

Complexity

Time: O(n)
Space: O(n)
 */
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            int need = sum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;

        System.out.println("Total subarrays with sum " + k + ": " + subarraySum(arr, k));
    }
}

// Total subarrays with sum 3: 2

/*
Explanation (Dry Run)

Array: [1, 2, 3]
k = 3

| Step | Num | Prefix Sum | Need = sum - k | Map Found? | Count |
| ---- | --- | ---------- | -------------- | ---------- | ----- |
| Init | -   | 0          | -              | map={0:1}  | 0     |
| 1    | 1   | 1          | -2             | No         | 0     |
| 2    | 2   | 3          | 0              | Yes (1)    | 1     |
| 3    | 3   | 6          | 3              | Yes (1)    | 2     |

Output = 2
 */