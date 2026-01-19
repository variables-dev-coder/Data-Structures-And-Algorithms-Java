package HASH_TABLES.revision;

import java.util.*;

public class AnagramDemo {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));
    }
}

