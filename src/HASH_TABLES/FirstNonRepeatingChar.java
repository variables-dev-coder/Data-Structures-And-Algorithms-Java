package HASH_TABLES;

/*
Find the first non-repeating character in a string using a Hash Table.
Example:
Input: "swiss"
Output: 'w'
(Explanation: s appears multiple times, but w appears only once and is the first such character.)
Solution Approach (Using HashMap):
Traverse the string and count frequency of each character using a HashMap.
Traverse the string again in order — the first character with frequency 1 is the answer.
 */


import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "swiss";

        // Step 1: Count frequencies
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first character with frequency = 1
        char result = '_'; // default if no non-repeating char
        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                result = c;
                break;
            }
        }

        System.out.println("First non-repeating character: " + result);
    }
}

/*
Dry Run for "swiss":
Count map → {s=3, w=1, i=1}
Traverse again:
's' → freq 3 → skip
'w' → freq 1 → answer found = 'w'
Output:
First non-repeating character: w
 */