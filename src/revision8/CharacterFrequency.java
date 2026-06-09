package revision8;

import java.util.*;

public class CharacterFrequency {

    public static void main(String[] args) {

        String s = "banana";

        HashMap<Character, Integer> map =
                new HashMap<>();

        for (char ch : s.toCharArray()) {

            map.put(
                    ch,
                    map.getOrDefault(ch, 0) + 1
            );
        }

        System.out.println(map);
    }
}
