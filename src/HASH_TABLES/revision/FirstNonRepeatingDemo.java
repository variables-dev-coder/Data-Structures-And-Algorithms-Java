package HASH_TABLES.revision;

import java.util.*;

public class FirstNonRepeatingDemo {

    public static char firstNonRepeating(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return '-';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));
    }
}

