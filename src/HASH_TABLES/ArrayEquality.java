package HASH_TABLES;

/*
Check if two arrays are equal or not (order doesn’t matter)
Problem:
Given two arrays, check if they contain the same elements with the same frequency, regardless of order.
Approach:
Use a HashMap to count frequencies of elements in the first array.
Decrease frequencies while traversing the second array.
If all frequencies are 0 at the end → arrays are equal.
 */

import java.util.HashMap;
import java.util.Map;

public class ArrayEquality {
    public static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of elements in arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Subtract frequency using arr2
        for (int num : arr2) {
            if (!map.containsKey(num)) return false;
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 5};
        int[] arr2 = {2, 3, 1, 5, 2};

        System.out.println(areEqual(arr1, arr2)); // true
    }
}

/*
Dry Run :

arr1 = {1,2,3,2,5}
map after arr1 = {1=1, 2=2, 3=1, 5=1}

arr2 = {2,3,1,5,2}
Take 2 → map {1=1,2=1,3=1,5=1}
Take 3 → map {1=1,2=1,5=1}
Take 1 → map {2=1,5=1}
Take 5 → map {2=1}
Take 2 → map {}
map is empty → true

 */