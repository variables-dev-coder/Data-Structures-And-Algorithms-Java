package Practices.Week_4;

/*
HashMap Problem
---------------
Longest Substring Without Repeating Characters
(Top Interview Question — Asked in Google, Amazon, Microsoft, Meta)

Given a string s, find the length of the longest substring without repeating characters.

Algorithm (Sliding Window + HashMap)
------------------------------------
1.Use HashMap<Character, Integer> to store last index of each character
2.Use two pointers:
    left pointer → start of window
    right pointer → current position
3.For each character:
    If it's already in map → move left to map.get(ch) + 1
    Update character's new index
Track max window size

Time: O(n)
Space: O(256) = effectively O(1) because ASCII size fixed
 */


import java.util.HashMap;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If seen and inside window: shrink window
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            // Store the latest index
            map.put(ch, right);

            // Window length = right - left + 1
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest substring length: " + lengthOfLongestSubstring(s));
    }
}

// Longest substring length: 3

/*
Explanation (Dry Run)

String: "abcabcbb"

| Right | Char | Window | Left | Max |
| ----- | ---- | ------ | ---- | --- |
| 0     | a    | a      | 0    | 1   |
| 1     | b    | ab     | 0    | 2   |
| 2     | c    | abc    | 0    | 3   |
| 3     | a    | bca    | 1    | 3   |
| 4     | b    | cab    | 2    | 3   |
| 5     | c    | abc    | 3    | 3   |

Final answer: 3

Interview Importance

This problem is asked in:
🔹 Amazon
🔹 Microsoft
🔹 Google
🔹 Meta
🔹 Adobe
🔹 Uber
🔹 Apple

Mastering HashMap + Sliding Window is MUST for interviews.

 */