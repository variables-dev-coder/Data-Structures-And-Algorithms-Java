package Practices.Week_2;

public class Q4_MissingNumber {
    public static int missing(int[] arr) {
        int xor = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) xor ^= i;
        for (int x : arr) xor ^= x;

        return xor;
    }

    public static void main(String[] args) {
        int[] a = {3,0,1};
        System.out.println(missing(a));    // 2
    }
}
