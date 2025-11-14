package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    /**
     * Problem: Check if array contains any duplicates
     * Concept: HashSet automatically handles duplicates - if add() returns false, duplicate exists
     * Time: O(n), Space: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            // HashSet.add() returns false if element already exists
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Contains Duplicate Problem:");
        System.out.println("Input: " + java.util.Arrays.toString(nums1));
        System.out.println("Output: " + containsDuplicate(nums1));
        System.out.println("Input: " + java.util.Arrays.toString(nums2));
        System.out.println("Output: " + containsDuplicate(nums2));
        System.out.println("Concept: HashSet's add() method detects duplicates efficiently");
        System.out.println();
    }
}

/*

Contains Duplicate Problem:
Input: [1, 2, 3, 1]
Output: true
Input: [1, 2, 3, 4]
Output: false
Concept: HashSet's add() method detects duplicates efficiently


Key Concept: HashSet's add() method returns false when element already exists,
making duplicate detection trivial.

 */