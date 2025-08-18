package DSA_Hash_Sets;

import java.util.HashSet;

/*
Problem Statement:
Given two arrays arr1 and arr2,
Find the Union → all unique elements from both arrays.
Find the Intersection → common elements between both arrays.

Input: arr1 = [1, 2, 3, 4], arr2 = [3, 4, 5, 6]
Union: [1, 2, 3, 4, 5, 6]
Intersection: [3, 4]

Expected Approach

Union:
Add all elements of arr1 and arr2 into a HashSet.
Intersection:
Add all elements of arr1 into a HashSet.
Traverse arr2, if an element exists in set → add to result.

 */

public class UnionIntersection {
    public static HashSet<Integer> getUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> unionSet = new HashSet<>();

        // Add all elements from both arrays
        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
        }

        return unionSet;
    }

    public static HashSet<Integer> getIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        // Add all elements of arr1 to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Check common elements
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        return intersectionSet;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};

        System.out.println("Union: " + getUnion(arr1, arr2));
        System.out.println("Intersection: " + getIntersection(arr1, arr2));
    }
}

/*
Dry Run
arr1 = [1, 2, 3, 4]
arr2 = [3, 4, 5, 6]

Union
Add 1,2,3,4 → unionSet = [1,2,3,4]
Add 3,4,5,6 → unionSet = [1,2,3,4,5,6]
Union Result = [1,2,3,4,5,6]

Intersection
set1 = [1,2,3,4]
Traverse arr2:
3 → yes → add → [3]
4 → yes → add → [3,4]
5 → no
6 → no

Intersection Result = [3,4]

Union: [1, 2, 3, 4, 5, 6]
Intersection: [3, 4]

Time Complexity: O(n + m)
Space Complexity: O(n + m)

 */