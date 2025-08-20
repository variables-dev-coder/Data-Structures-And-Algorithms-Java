package DSA_Hash_Sets;

// Remove Duplicates from an Array

import java.util.HashSet;

public class HashSetExample1 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 2, 4, 9, 7, 1};

        HashSet<Integer> unique = new HashSet<>();

        for (int num : arr) {
            unique.add(num); // HashSet automatically ignores duplicates
        }

        System.out.println("Unique Elements: " + unique);
    }

}

// Unique Elements: [1, 2, 4, 7, 9]

//Here, HashSet is used because it stores only unique elements.