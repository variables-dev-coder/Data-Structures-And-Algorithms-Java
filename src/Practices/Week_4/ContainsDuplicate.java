package Practices.Week_4;

import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num);
        }

        return false; // no duplicate
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {5, 5, 5, 5};

        System.out.println(containsDuplicate(arr1)); // true
        System.out.println(containsDuplicate(arr2)); // false
        System.out.println(containsDuplicate(arr3)); // true
    }
}
