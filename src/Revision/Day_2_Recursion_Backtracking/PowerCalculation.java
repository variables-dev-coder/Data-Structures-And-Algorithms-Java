package Revision.Day_2_Recursion_Backtracking;

public class PowerCalculation {
    public static int power(int x, int n) {
        if ( n == 0) {
            return 1;   // base case: anything^0 = 1
        }
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 7;
        System.out.println(x + "^" + n + " = " + power(x, n));
    }
}
