package queue_Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {

    public static boolean isPalindrome(String str) {

        // Convert to lowercase
        str = str.toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Add characters
        for (char ch : str.toCharArray()) {

            deque.addLast(ch);
        }

        // Compare both ends
        while (deque.size() > 1) {

            char first = deque.removeFirst();

            char last = deque.removeLast();

            if (first != last) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String str1 = "Madam";
        String str2 = "RaceCar";
        String str3 = "Hello";

        System.out.println(str1 + " -> "
                + isPalindrome(str1));

        System.out.println(str2 + " -> "
                + isPalindrome(str2));

        System.out.println(str3 + " -> "
                + isPalindrome(str3));
    }
}
