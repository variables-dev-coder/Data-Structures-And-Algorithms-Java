package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    /**
     * Problem: Find first missing positive integer
     * Concept: Store numbers in HashSet, check numbers 1 to n+1
     * Time: O(n), Space: O(n)
     */
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        // Add all numbers to HashSet
        for (int num : nums) {
            numSet.add(num);
        }

        // Check numbers from 1 to n+1
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println("First Missing Positive:");
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + firstMissingPositive(nums));
        System.out.println("Concept: Store numbers, then check sequential numbers for first missing");
        System.out.println();
    }
}

/*
First Missing Positive:
Input: [3, 4, -1, 1]
Output: 2
Concept: Store numbers, then check sequential numbers for first missing

Key Concept: The first missing positive must be between 1 and n+1, so we only need to check this range.
 */