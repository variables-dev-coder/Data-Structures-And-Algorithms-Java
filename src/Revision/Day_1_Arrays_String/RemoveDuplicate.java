package Revision.Day_1_Arrays_String;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static String removeDuplicates(String s) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String  result = removeDuplicates(input);
        System.out.println("After removing duplicated " + result);
    }
}
