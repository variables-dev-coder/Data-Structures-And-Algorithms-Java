package revision8;

import java.util.*;

public class AnagramCheck {

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        HashMap<Character, Integer> map =
                new HashMap<>();

        for (char ch : s1.toCharArray()) {

            map.put(
                    ch,
                    map.getOrDefault(ch, 0) + 1
            );
        }

        for (char ch : s2.toCharArray()) {

            map.put(
                    ch,
                    map.get(ch) - 1
            );

            if (map.get(ch) == 0) {

                map.remove(ch);
            }
        }

        System.out.println(
                map.isEmpty()
        );
    }
}
