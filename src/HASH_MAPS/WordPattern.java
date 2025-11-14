package HASH_MAPS;

import java.util.*;

public class WordPattern {
    /**
     * Problem: Check if string follows given pattern
     * Concept: Use two HashMaps for character->word and word->character mapping
     * Time: O(n), Space: O(n)
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check character to word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check word to character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println("=== Word Pattern ===");
        System.out.println("Pattern: \"" + pattern + "\"");
        System.out.println("String: \"" + s + "\"");
        System.out.println("Output: " + wordPattern(pattern, s));
        System.out.println("Concept: Bi-directional mapping to ensure one-to-one correspondence");
        System.out.println();
    }
}

/*
=== Word Pattern ===
Pattern: "abba"
String: "dog cat cat dog"
Output: true
Concept: Bi-directional mapping to ensure one-to-one correspondence

Word Pattern
Concept Used: Bi-directional Mapping

Key Concept: Use two HashMaps to ensure both character->word and word->character mappings are consistent.
 */
