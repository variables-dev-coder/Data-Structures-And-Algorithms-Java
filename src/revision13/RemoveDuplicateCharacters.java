package revision13;

import java.util.HashSet;

public class RemoveDuplicateCharacters {

    public static String removeDuplicates(String str) {

        HashSet<Character> set = new HashSet<>();

        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {

            if (!set.contains(ch)) {

                set.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String str = "programming";

        System.out.println(removeDuplicates(str));
    }
}
