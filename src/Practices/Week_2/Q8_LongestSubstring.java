package Practices.Week_2;

import java.util.HashSet;

public class Q8_LongestSubstring {
    public static int lengthOfLongest(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0, j=0, max=0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongest("abcabcbb"));   // 3
    }
}
