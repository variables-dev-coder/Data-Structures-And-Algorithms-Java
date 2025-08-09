package Revision.Day_2_Recursion_Backtracking;

public class ReverseNumber {
    public static int reverseNumber(int n) {
        int digits = (int) Math.log10(n);    // Number of digits - 1
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == 0) {
            return n;  // Base case: single digit number
        }
        int lastDigit = n % 10;
        return lastDigit * (int) Math.pow(10, digits) + helper(n / 10, digits - 1);
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println("Reverse: " + reverseNumber(n));   // 4321
    }
}
