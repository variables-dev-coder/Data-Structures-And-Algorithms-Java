package DSA_Hash_Sets;

import java.util.HashSet;

public class FirstRepeatingElement1 {
    public static int findFirstRepeating(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int firstRepeating = -1;

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                firstRepeating = arr[i]; // candidate
            } else {
                set.add(arr[i]);
            }
        }
        return firstRepeating;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 3, 4, 3, 5, 6};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println("First repeating element: " + findFirstRepeating(arr1)); // 5
        System.out.println("First repeating element: " + findFirstRepeating(arr2)); // -1
    }
}

/*
Dry Run (Corrected)
arr = [10, 5, 3, 4, 3, 5, 6]

Scanning from right → left:
6 → new
5 → new
3 → new
4 → new
3 → already seen → firstRepeating = 3
5 → already seen → firstRepeating = 5
10 → new

Final answer = 5 (correct).

First repeating element: 5
First repeating element: -1

 */