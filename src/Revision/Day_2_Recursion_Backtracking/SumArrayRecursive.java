package Revision.Day_2_Recursion_Backtracking;

public class SumArrayRecursive {
    static int sumArray(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Sum: " + sumArray(arr, arr.length));
    }
}

/*

sumArray([1,2,3,4,5],5) = 5 + sumArray([1,2,3,4],4)
...
= 5 + 4 + 3 + 2 + 1 = 15

 */