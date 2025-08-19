package HASH_MAPS;

/*
Problem: First Non-Repeating Character in a String

Given a string, find the index of the first character that does not repeat.
If it doesn’t exist, return -1.

Example
Input:  "leetcode"
Output: 0   // 'l' is the first non-repeating character
Input:  "loveleetcode"
Output: 2   // 'v' is the first non-repeating character
Input:  "aabb"
Output: -1  // no non-repeating character

Logic with HashMap
Traverse the string and store the frequency of each character in a HashMap.
Key → character
Value → count
Traverse the string again (in original order).
Find the first character with frequency = 1.
Return its index.
If none → return -1.

 */

import java.util.HashMap;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first char with freq=1
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));     // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqChar("aabb"));         // -1
    }
}

/*

Dry Run

s = "loveleetcode"
Step 1 (frequency count):
{l=2, o=2, v=1, e=4, t=1, c=1, d=1}
Step 2 (find first unique):
i=0 → 'l' (freq=2) → skip
i=1 → 'o' (freq=2) → skip
i=2 → 'v' (freq=1)  found

Answer = 2
 */