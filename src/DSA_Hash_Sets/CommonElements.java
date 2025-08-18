package DSA_Hash_Sets;

/*
Problem: Find Common Elements in Two Arrays

Problem Statement:
Given two integer arrays arr1 and arr2, write a Java program to
find all elements that are present in both arrays using HashSet.

Example 1:
Input: arr1 = [1, 2, 2, 3, 4], arr2 = [3, 4, 4, 5, 6]
Output: [3, 4]
Explanation: Elements 3 and 4 are present in both arrays.

Input: arr1 = [10, 20, 30], arr2 = [40, 50, 60]
Output: []
Explanation: No common elements.

Expected Approach
Add all elements of arr1 to a HashSet (set1).
Traverse arr2 and check for each element if it exists in set1.
If it exists, add it to a result set (resultSet) to maintain uniqueness.
Return or print resultSet.

 */


import java.util.HashSet;

public class CommonElements {
    public static HashSet<Integer> findCommon(int[] arr1, int[] arr2) {
        // Step 1: Add all elements of arr1 to a HashSet
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Step 2: Create a result set to store common elements
        HashSet<Integer> resultSet = new HashSet<>();

        // Step 3: Traverse arr2 and check if element exists in set1
        for (int num : arr2) {
            if (set1.contains(num)) {
                resultSet.add(num); // add to result set (duplicates automatically ignored)
            }
        }

        return resultSet;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {3, 4, 4, 5, 6};

        HashSet<Integer> commonElements = findCommon(arr1, arr2);
        System.out.println("Common elements: " + commonElements);
    }
}

/*
Explanation Step by Step

Add arr1 elements to HashSet (set1):
set1 = [1, 2, 3, 4] (duplicates ignored)
Traverse arr2 and check for each element:
3 → exists in set1 → add to resultSet
4 → exists in set1 → add to resultSet
4 → already in resultSet → ignored
5 → not in set1 → ignored
6 → not in set1 → ignored
ResultSet contains [3, 4]

Dry Run Table
| arr2 Element | Exists in arr1 set? | ResultSet After Step        |
| ------------ | ------------------- | --------------------------- |
| 3            | Yes                 | \[3]                        |
| 4            | Yes                 | \[3, 4]                     |
| 4            | Yes                 | \[3, 4] (duplicate ignored) |
| 5            | No                  | \[3, 4]                     |
| 6            | No                  | \[3, 4]                     |
Common elements: [3, 4]


Time Complexity: O(n + m)
n = length of arr1, m = length of arr2
Adding elements and checking contains() is O(1) on average.
Space Complexity: O(n + k)
n for set1, k = number of common elements for resultSet

 */