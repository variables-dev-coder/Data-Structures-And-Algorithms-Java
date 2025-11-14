package HASH_MAPS;

import java.util.*;

public class GroupAnagrams {
    /**
     * Problem: Group strings that are anagrams together
     * Concept: Use sorted string or frequency array as key in HashMap
     * Time: O(n * k log k), Space: O(n * k)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array, sort it, and use as key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // If key doesn't exist, create new list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add original string to the list
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("=== Group Anagrams ===");
        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Output: " + groupAnagrams(strs));
        System.out.println("Concept: Use sorted string as HashMap key to group anagrams");
        System.out.println();
    }
}

/*
=== Group Anagrams ===
Input: [eat, tea, tan, ate, nat, bat]
Output: [[eat, tea, ate], [bat], [tan, nat]]
Concept: Use sorted string as HashMap key to group anagrams


Group Anagrams
Concept Used: Frequency Map as Key

Key Concept: Anagrams become identical when sorted, so we can use sorted strings as HashMap keys.
 */