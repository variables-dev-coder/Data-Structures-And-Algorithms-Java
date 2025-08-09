package Revision.Day_2_Recursion_Backtracking;

public class SumOfDigits {

    public static int sumOfDigit(int n) {
        // base case
        if ( n == 0) return 0;

        // recursive case - last digit + sum of remaining digits
        return (n % 10) + sumOfDigit(n / 10);
    }

    public static void main(String[] args) {
        int n = 123415627;
        System.out.println("Sum of digits: " + sumOfDigit(n));
    }
}
