package Queue.Deque;


/*
Problem Statement

Given a string, check whether it is a palindrome using a Deque.
A palindrome is a string that reads the same forwards and backwards.

Example:

Input: "madam"
Output: true

Input: "hello"
Output: false

Approach (Using Deque)
1.Create a Deque and insert all characters of the string into it.
2.While there are 2 or more characters in the deque:
    Remove one from the front and one from the rear.
    If they are not the same → return false.
3.If the loop completes without mismatches → return true.

 */

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeUsingDeque {
    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        // Add all characters to deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("hello")); // false
    }
}

/*
Dry Run

Example: "madam"

Deque after adding: [m, a, d, a, m]
Front = m, Rear = m → match
Deque = [a, d, a]
Front = a, Rear = a → match
Deque = [d] → size = 1 → stop


Output: true
 */