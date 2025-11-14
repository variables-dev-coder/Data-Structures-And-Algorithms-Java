package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    /**
     * Problem: Count how many stones are jewels
     * Concept: Store jewels in HashSet for O(1) membership testing
     * Time: O(n + m), Space: O(m) where m is jewels length
     */
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();

        // Add all jewel characters to HashSet
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        // Count stones that are jewels
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println("Jewels and Stones:");
        System.out.println("Jewels: " + jewels);
        System.out.println("Stones: " + stones);
        System.out.println("Output: " + numJewelsInStones(jewels, stones));
        System.out.println("Concept: HashSet for fast membership testing");
        System.out.println();
    }
}

/*
Jewels and Stones:
Jewels: aA
Stones: aAAbbbb
Output: 3
Concept: HashSet for fast membership testing

Key Concept: HashSet provides O(1) membership testing, making it perfect for counting occurrences.
 */