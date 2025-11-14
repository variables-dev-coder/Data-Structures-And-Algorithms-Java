package HASH_MAPS;

import java.util.*;

public class IntersectionArraysII {
    /**
     * Problem: Find intersection of two arrays with duplicates
     * Concept: Use HashMap to store frequencies, decrement when found in second array
     * Time: O(n + m), Space: O(min(n, m))
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Always use the smaller array for HashMap to save space
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequencies in first array
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check second array and decrement counts
        for (int num : nums2) {
            int count = freqMap.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                freqMap.put(num, count - 1);
            }
        }

        // Convert list to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("=== Intersection of Two Arrays II ===");
        System.out.println("Input 1: " + Arrays.toString(nums1));
        System.out.println("Input 2: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(intersect(nums1, nums2)));
        System.out.println("Concept: Frequency map with decrement for handling duplicates");
        System.out.println();
    }
}

/*
Intersection of Two Arrays II
Concept Used: Frequency Map with Decrement

=== Intersection of Two Arrays II ===
Input 1: [1, 2, 2, 1]
Input 2: [2, 2]
Output: [2, 2]
Concept: Frequency map with decrement for handling duplicates

Key Concept: Store frequencies and decrement them when elements are found in the second array.
 */
