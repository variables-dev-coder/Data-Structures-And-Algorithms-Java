package DSA_Hash_Sets;

/*
Problem Statement:
Given an unsorted integer array arr, find the length of the longest consecutive elements sequence using HashSet.

Example 1:
Input: arr = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive sequence is [1, 2, 3, 4].

Input: arr = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output: 9
Explanation: The longest consecutive sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8].

Expected Approach (HashSet Optimized)
Add all elements to a HashSet for O(1) lookup.
Iterate through the array. For each element, check if it is the start of a sequence:
If num-1 does not exist in the set → it’s the start of a sequence.
Count consecutive numbers starting from that element.
Keep track of the maximum sequence length.

 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        // Step 1: Add all elements to HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: Iterate through array and find sequences
        for (int num : arr) {
            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                // Update maximum length
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr));
    }
}

/*
Explanation Step by Step

HashSet for O(1) lookup:
set = [100, 4, 200, 1, 3, 2]
Check each element if it’s start of a sequence:
Start if num-1 does not exist in the set.
Counting consecutive numbers:
1 → start (0 not in set) → check 2, 3, 4 → sequence length = 4
2 → not start (1 exists) → skip
3 → not start (2 exists) → skip
4 → not start (3 exists) → skip
100 → start (99 not in set) → length = 1
200 → start (199 not in set) → length = 1

Maximum length: 4

Dry Run Table

| Element | Start of sequence? | Count consecutive | Max Length |
| ------- | ------------------ | ----------------- | ---------- |
| 100     | Yes                | 1                 | 1          |
| 4       | No                 | -                 | 1          |
| 200     | Yes                | 1                 | 1          |
| 1       | Yes                | 1 → 2 → 3 → 4     | 4          |
| 3       | No                 | -                 | 4          |
| 2       | No                 | -                 | 4          |

Longest consecutive sequence length: 4

Time Complexity: O(n)

Each element is processed at most twice.

Space Complexity: O(n)

For the HashSet.

 */