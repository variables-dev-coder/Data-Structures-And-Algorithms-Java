package Revision.Day_2_Recursion_Backtracking;

public class RecursionExample {
    static int factorial(int n) {

        if (n == 0) return 1;    // base case

        return n * factorial(n - 1);   // Recursive case
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
    }
}
