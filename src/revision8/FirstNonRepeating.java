package revision8;

import java.util.HashMap;

public class FirstNonRepeating {

    static char firstNonRepeating(String str) {

        HashMap<Character, Integer> map =
                new HashMap<>();

        // Count frequency
        for (char ch : str.toCharArray()) {

            map.put(
                    ch,
                    map.getOrDefault(ch, 0) + 1
            );
        }

        // Find first frequency 1
        for (char ch : str.toCharArray()) {

            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '#';
    }

    public static void main(String[] args) {

        String str = "leetcode";

        System.out.println(
                firstNonRepeating(str)
        );
    }
}
