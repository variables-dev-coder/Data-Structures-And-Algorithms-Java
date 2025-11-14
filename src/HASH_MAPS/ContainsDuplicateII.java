package HASH_MAPS;

import java.util.*;

public class ContainsDuplicateII {
    /**
     * Problem: Check if array contains nearby duplicates within k distance
     * Concept: Use HashMap to store last seen index of each element
     * Time: O(n), Space: O(n)
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // If we've seen this number before and within k distance
            if (lastSeen.containsKey(num) && i - lastSeen.get(num) <= k) {
                return true;
            }

            // Update last seen index
            lastSeen.put(num, i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println("=== Contains Duplicate II ===");
        System.out.println("Input: " + Arrays.toString(nums) + ", k=" + k);
        System.out.println("Output: " + containsNearbyDuplicate(nums, k));
        System.out.println("Concept: Store last seen indices and check distance");
        System.out.println();
    }
}

/*
=== Contains Duplicate II ===
Input: [1, 2, 3, 1], k=3
Output: true
Concept: Store last seen indices and check distance

Contains Duplicate II (HashMap Version)
Concept Used: Index Storage with HashMap

Key Concept: Store the most recent index of each element and check if current index is within k distance.
 */