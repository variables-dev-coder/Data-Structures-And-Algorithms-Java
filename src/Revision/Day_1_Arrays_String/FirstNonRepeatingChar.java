package Revision.Day_1_Arrays_String;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '_'; // Not found
    }

    public static void main(String[] args) {
        String input = "swiss";
        char result = firstNonRepeatingChar(input);
        System.out.println("First non-repeating character: " + result);  // Output: w
    }
}
