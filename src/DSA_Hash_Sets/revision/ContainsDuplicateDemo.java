package DSA_Hash_Sets.revision;

import java.util.HashSet;

public class ContainsDuplicateDemo {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) { // already exists
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 1};

        System.out.println(containsDuplicate(arr1)); // false
        System.out.println(containsDuplicate(arr2)); // true
    }
}

