package Revision.Day_2_Recursion_Backtracking;

public class PrintNumbersRecursively {
    static void printNumbers(int n) {

        // base case
        if (n == 0) return;

        // recursive call
        printNumbers(n - 1);

        System.out.print(n + " ");  // Action after recursion
    }

    public static void main(String[] args) {
        printNumbers(5);   // 1 2 3 4 5
    }
}
