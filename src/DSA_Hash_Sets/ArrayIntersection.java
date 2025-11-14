package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    /**
     * Problem: Find intersection of two arrays (common elements)
     * Concept: Use two HashSets - one for storage, one for result
     * Time: O(n + m), Space: O(min(n, m))
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add all elements from first array
        for (int num : nums1) {
            set1.add(num);
        }

        // Check which elements exist in both arrays
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert HashSet to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("Intersection of Two Arrays:");
        System.out.println("Input 1: " + java.util.Arrays.toString(nums1));
        System.out.println("Input 2: " + java.util.Arrays.toString(nums2));
        System.out.println("Output: " + java.util.Arrays.toString(intersection(nums1, nums2)));
        System.out.println("Concept: Set operations - store first array, check second array");
        System.out.println();
    }
}

/*
Intersection of Two Arrays:
Input 1: [1, 2, 2, 1]
Input 2: [2, 2]
Output: [2]
Concept: Set operations - store first array, check second array

Key Concept: Use HashSet operations to efficiently find common elements between two arrays.

 */