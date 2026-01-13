package DSA_Hash_Sets.revision;

import java.util.*;

public class CheckAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println(false);
                return;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        System.out.println(map.isEmpty());
    }
}

