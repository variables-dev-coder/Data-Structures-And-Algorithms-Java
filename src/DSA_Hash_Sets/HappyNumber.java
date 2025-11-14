package DSA_Hash_Sets;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     * Problem: Determine if a number is happy (reaches 1 after sum of squares of digits)
     * Concept: Use HashSet to detect cycles - if we see a number again, it's not happy
     * Time: O(log n), Space: O(log n)
     */
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextNumber(n);
        }

        return n == 1;
    }

    private static int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] testCases = {19, 2};

        System.out.println("Happy Number Problem:");
        for (int num : testCases) {
            System.out.println("Input: " + num);
            System.out.println("Output: " + isHappy(num));
        }
        System.out.println("Concept: Cycle detection - if number repeats, it's in infinite loop");
        System.out.println();
    }
}

/*

Happy Number Problem:
Input: 19
Output: true
Input: 2
Output: false
Concept: Cycle detection - if number repeats, it's in infinite loop

Key Concept: HashSet detects cycles - if we encounter the same number twice, we're in an infinite loop.
 */