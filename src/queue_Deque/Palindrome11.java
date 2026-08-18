package queue_Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome11 {

    public static boolean isPalindrome(String str) {

        // Convert to lowercase
        str = str.toLowerCase();

        // Remove spaces
        str = str.replace(" ", "");

        Deque<Character> deque = new ArrayDeque<>();

        // Add characters
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare both ends
        while (deque.size() > 1) {

            char first = deque.removeFirst();

            char last = deque.removeLast();

            System.out.println(
                    "Comparing: " + first + " and " + last
            );

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String str1 = "Madam";
        String str2 = "Race Car";
        String str3 = "Hello";
        String str4 = "Never Odd Or Even";

        System.out.println(
                str1 + " -> " + isPalindrome(str1)
        );

        System.out.println();

        System.out.println(
                str2 + " -> " + isPalindrome(str2)
        );

        System.out.println();

        System.out.println(
                str3 + " -> " + isPalindrome(str3)
        );

        System.out.println();

        System.out.println(
                str4 + " -> " + isPalindrome(str4)
        );

    }
}
