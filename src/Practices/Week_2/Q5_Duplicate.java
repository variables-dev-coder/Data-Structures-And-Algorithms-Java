package Practices.Week_2;

import java.util.HashSet;

public class Q5_Duplicate {
    public static boolean contains(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) if (!set.add(x)) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        System.out.println(contains(a));   // true
    }
}
