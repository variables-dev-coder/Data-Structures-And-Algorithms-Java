package queue_Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeUsingDeque {

    public static boolean isPalindrome(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        // Put every character into Deque
        for (char ch : str.toCharArray()) {

            deque.addLast(ch);
        }

        // Compare first and last characters
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

        String str1 = "madam";
        String str2 = "racecar";
        String str3 = "hello";
        String str4 = "level";

        System.out.println(str1 + " -> "
                + isPalindrome(str1));

        System.out.println(str2 + " -> "
                + isPalindrome(str2));

        System.out.println(str3 + " -> "
                + isPalindrome(str3));

        System.out.println(str4 + " -> "
                + isPalindrome(str4));
    }
}
