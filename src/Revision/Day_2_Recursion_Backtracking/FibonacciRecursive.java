package Revision.Day_2_Recursion_Backtracking;


// Base cases: fib(0) = 0, fib(1) = 1
//Recursive: fib(n) = fib(n-1) + fib(n-2)


public class FibonacciRecursive {
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;   // print first 6 Fibonacci number
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}

/*
fib(4) → fib(3) + fib(2)
fib(3) → fib(2) + fib(1)
fib(2) → fib(1) + fib(0)

 */