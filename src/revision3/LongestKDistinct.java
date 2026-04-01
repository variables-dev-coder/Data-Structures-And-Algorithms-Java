package revision3;

import java.util.HashMap;

public class LongestKDistinct {

    public static int longestSubstringKDistinct(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if more than k distinct chars
            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "eceba";
        int k = 2;

        int result = longestSubstringKDistinct(s, k);
        System.out.println("Longest Length: " + result);
    }
}
