package HASH_MAPS;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    /**
     * Problem: Find first non-repeating character and return its index
     * Concept: Use HashMap to count character frequencies, then find first with count 1
     * Time: O(n), Space: O(1) - only 26 letters
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character
    }

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println("=== First Unique Character ===");
        System.out.println("Input: \"" + s + "\"");
        System.out.println("Output: " + firstUniqChar(s));
        System.out.println("Concept: Frequency counting with HashMap, then linear scan");
        System.out.println();
    }
}

/*
First Unique Character in String
Concept Used: Frequency Counting with HashMap

=== First Unique Character ===
Input: "leetcode"
Output: 0
Concept: Frequency counting with HashMap, then linear scan

Key Concept: Two-pass approach - first count frequencies, then find first character with count 1.
 */