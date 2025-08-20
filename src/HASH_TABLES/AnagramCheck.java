package HASH_TABLES;

/*
Check if Two Strings are Anagrams
Problem: Given two strings, check if they are anagrams (contain the same characters with same frequency).

Logic:

If lengths differ → not anagrams.
Use a HashMap to count character frequencies in the first string.
Decrease counts while traversing the second string.
If all counts become zero → strings are anagrams.
 */


import java.util.HashMap;

public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using s2
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Are Anagrams? " + isAnagram(s1, s2));
    }
}

// Are Anagrams? true