package HASH_MAPS;

/*
Problem: Check if Two Strings are Anagrams

Given two strings, check if they are anagrams.
Two strings are anagrams if they contain the same characters with the
same frequency, but possibly in different order.

Example
Input:  s = "listen", t = "silent"
Output: true

Input:  s = "rat", t = "car"
Output: false

Logic with HashMap
If lengths differ → return false immediately.
Use a HashMap<Character, Integer> to count frequency of characters in s.
Traverse t and decrease frequency.
If at any point frequency goes below zero → not an anagram.
If map is empty at the end → strings are anagrams.
 */

import java.util.HashMap;

public class AnagramCheck {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of chars in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency for chars in t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("rat", "car"));       // false
    }
}

/*
🔹 Dry Run

s = "listen", t = "silent"

Count frequencies of s:
{l=1, i=1, s=1, t=1, e=1, n=1}

Traverse t:

remove 's' → {l=1, i=1, t=1, e=1, n=1}

remove 'i' → {l=1, t=1, e=1, n=1}

remove 'l' → {t=1, e=1, n=1}

remove 'e' → {t=1, n=1}

remove 'n' → {t=1}

remove 't' → {}

map is empty → strings are anagrams.

Output:

true
false

 */