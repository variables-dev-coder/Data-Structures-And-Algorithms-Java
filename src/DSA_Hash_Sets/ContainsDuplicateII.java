package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    /**
     * Problem: Check if array contains nearby duplicates within distance k
     * Concept: Maintain sliding window of size k using HashSet
     * Time: O(n), Space: O(k)
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove element that's now outside the window
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If current element exists in window, we found nearby duplicate
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println("Contains Duplicate II:");
        System.out.println("Input: " + java.util.Arrays.toString(nums) + ", k=" + k);
        System.out.println("Output: " + containsNearbyDuplicate(nums, k));
        System.out.println("Concept: Sliding window of size k maintained by HashSet");
        System.out.println();
    }
}

/*
Contains Duplicate II:
Input: [1, 2, 3, 1], k=3
Output: true
Concept: Sliding window of size k maintained by HashSet

Key Concept: Maintain a sliding window of the last k elements using HashSet for O(1) duplicate checks.
 */