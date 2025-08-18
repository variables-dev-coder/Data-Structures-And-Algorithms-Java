package DSA_Hash_Sets;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] arr) {
        // Step 1: Create a HashSet
        HashSet<Integer> set = new HashSet<>();

        // Step 2: Traverse array
        for (int num : arr) {
            // If element already exists → duplicate found
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            set.add(num);
        }

        // Step 3: No duplicates found
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println("Contains duplicate? " + hasDuplicate(arr1)); // true
        System.out.println("Contains duplicate? " + hasDuplicate(arr2)); // false
    }
}
