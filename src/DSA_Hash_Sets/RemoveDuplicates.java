package DSA_Hash_Sets;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 10};
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }
        System.out.println("Unique element: " + set);
    }
}

// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10