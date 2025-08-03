package Revision.Day_1_Arrays_String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((mapST.containsKey(ch1) && mapST.get(ch1) != ch2) ||
                    (mapTS.containsKey(ch2) && mapTS.get(ch2) != ch1)) {
                return false;
            }

            mapST.put(ch1, ch2);
            mapTS.put(ch2, ch1);
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        System.out.println("Are isomorphic: " + isIsomorphic(s1, s2)); // Output: true
    }
}
