package HASH_MAPS;

/*
Problem: Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example
Input:  "abcabcbb"
Output: 3   // "abc"

Input:  "bbbbb"
Output: 1   // "b"

Input:  "pwwkew"
Output: 3   // "wke"

Logic with HashMap + Sliding Window
We use sliding window technique + HashMap.
Use a HashMap to store the last index of each character.
Use two pointers: start and end → current window.
For each character at end:
If char already exists in map and index ≥ start → move start to map[char] + 1.
Update map with current index of char.
Calculate window length = end - start + 1.
Update max length.

Time Complexity: O(n)
Space Complexity: O(n)
 */

import java.util.HashMap;

public class LongestSubstringUnique {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1; // move start after repeated char
            }

            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

/*
Dry Run

s = "abcabcbb"

end=0 → "a" → window = [0,0] → len=1 → max=1

end=1 → "b" → window = [0,1] → len=2 → max=2

end=2 → "c" → window = [0,2] → len=3 → max=3

end=3 → "a" (repeated at 0) → move start=1 → window [1,3] → len=3 → max=3

end=4 → "b" (repeated at 1) → move start=2 → window [2,4] → len=3 → max=3

end=5 → "c" (repeated at 2) → move start=3 → window [3,5] → len=3 → max=3

end=6 → "b" (repeated at 4) → move start=5 → window [5,6] → len=2 → max=3

end=7 → "b" (repeated at 6) → move start=7 → window [7,7] → len=1 → max=3

Answer = 3
 */