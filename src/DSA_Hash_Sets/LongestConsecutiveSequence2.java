package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence2 {
    /**
     * Problem: Find longest consecutive sequence length
     * Concept: Store all numbers in HashSet, then find sequence starts
     * Time: O(n), Space: O(n)
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        // Add all numbers to HashSet for O(1) lookups
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if this is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Longest Consecutive Sequence:");
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Output: " + longestConsecutive(nums));
        System.out.println("Concept: Find sequence starts (numbers without left neighbor) then expand right");
        System.out.println();
    }
}


/*


Longest Consecutive Sequence:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Concept: Find sequence starts (numbers without left neighbor) then expand right

Key Concept: Only start counting sequences from numbers that don't have a
left neighbor (num-1), ensuring O(n) time.
 */