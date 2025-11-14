package HASH_MAPS;

import java.util.*;

public class IsomorphicStrings {
    /**
     * Problem: Check if two strings are isomorphic (characters can be replaced to get second string)
     * Concept: Use two HashMaps to track character mappings in both directions
     * Time: O(n), Space: O(1) - only 256 characters
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false;
                }
            } else {
                sToT.put(charS, charT);
            }

            // Check mapping from t to s
            if (tToS.containsKey(charT)) {
                if (tToS.get(charT) != charS) {
                    return false;
                }
            } else {
                tToS.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";

        System.out.println("=== Isomorphic Strings ===");
        System.out.println("\"egg\" and \"add\": " + isIsomorphic(s1, t1)); // true
        System.out.println("\"foo\" and \"bar\": " + isIsomorphic(s2, t2)); // false
        System.out.println("Concept: Bi-directional character mapping validation");
        System.out.println();
    }
}

/*
Isomorphic Strings
Concept Used: Character Mapping Validation

Key Concept: Ensure one-to-one mapping between characters in both strings using two HashMaps.

=== Isomorphic Strings ===
"egg" and "add": true
"foo" and "bar": false
Concept: Bi-directional character mapping validation

 */
