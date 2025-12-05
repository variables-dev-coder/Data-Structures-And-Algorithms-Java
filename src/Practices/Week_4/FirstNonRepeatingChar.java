package Practices.Week_4;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    public static char firstNonRepeating(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: find first char with freq = 1
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '-'; // not found
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("leetcode")); // l
        System.out.println(firstNonRepeating("loveleetcode")); // v
        System.out.println(firstNonRepeating("aabb")); // -
    }
}
