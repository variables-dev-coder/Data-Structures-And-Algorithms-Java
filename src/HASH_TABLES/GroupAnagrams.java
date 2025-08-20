package HASH_TABLES;

/*
Group Anagrams
Given an array of strings, group the anagrams together.
Two words are anagrams if they contain the same characters in different orders.

Example
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

Approach using Hash Table (HashMap)
Use a HashMap where:
Key = sorted version of the word (so "eat", "tea", "ate" all become "aet")
Value = list of words that share this key.
Traverse all words and insert them into the map.
Finally, return all values of the map.
 */

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Sort characters to make key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Insert into map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(words));
    }
}

/*
Dry Run

Input: ["eat","tea","tan","ate","nat","bat"]
"eat" → key "aet" → map = { "aet": ["eat"] }
"tea" → key "aet" → map = { "aet": ["eat","tea"] }
"tan" → key "ant" → map = { "aet": ["eat","tea"], "ant":["tan"] }
"ate" → key "aet" → map = { "aet": ["eat","tea","ate"], "ant":["tan"] }
"nat" → key "ant" → map = { "aet": ["eat","tea","ate"], "ant":["tan","nat"] }
"bat" → key "abt" → map = { "aet":[...], "ant":[...], "abt":["bat"] }
Output = [["eat","tea","ate"], ["tan","nat"], ["bat"]]

 */