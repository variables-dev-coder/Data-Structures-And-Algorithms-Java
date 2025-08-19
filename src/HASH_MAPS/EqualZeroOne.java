package HASH_MAPS;

/*
Problem: Subarray with Equal 0s and 1s

Given a binary array (containing only 0 and 1), find the length of the longest
subarray with equal number of 0s and 1s.

Example
Input:  [0, 1]
Output: 2   // [0,1]

Input:  [0, 1, 0]
Output: 2   // [0,1] or [1,0]

Input:  [0, 0, 1, 0, 1, 1, 0]
Output: 6   // [0,1,0,1,1,0]

Logic with HashMap (Prefix Sum Trick)

Replace all 0s with -1.

Now, the problem becomes: Find longest subarray with sum = 0.

Maintain a prefix sum while traversing.

Use HashMap to store first occurrence of a prefix sum.

If prefix sum repeats → subarray between them has sum=0.

Update max length.

Time Complexity → O(n)
Space Complexity → O(n)
 */


import java.util.HashMap;

public class EqualZeroOne {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        map.put(0, -1); // prefix sum 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1};
        System.out.println(findMaxLength(arr1)); // 2

        int[] arr2 = {0, 1, 0};
        System.out.println(findMaxLength(arr2)); // 2

        int[] arr3 = {0, 0, 1, 0, 1, 1, 0};
        System.out.println(findMaxLength(arr3)); // 6
    }
}

/*
Dry Run

arr = [0, 0, 1, 0, 1, 1, 0]

Convert 0→-1 → [-1, -1, 1, -1, 1, 1, -1]

Prefix sum sequence:

i=0 → sum=-1 → store {-1=0}
i=1 → sum=-2 → store {-2=1}
i=2 → sum=-1 → already seen at 0 → len=2 → max=2
i=3 → sum=-2 → already seen at 1 → len=2 → max=2
i=4 → sum=-1 → already seen at 0 → len=4 → max=4
i=5 → sum=0  → already seen at -1 → len=6 → max=6
i=6 → sum=-1 → already seen at 0 → len=6 → max=6


Answer = 6

 */