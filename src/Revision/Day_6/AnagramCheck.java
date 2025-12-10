package Revision.Day_6;

public class AnagramCheck {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        // Count frequency from first string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Reduce frequency from second string
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        // Check if all frequencies are zero
        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println(isAnagram(s1, s2));  // true
    }
}

