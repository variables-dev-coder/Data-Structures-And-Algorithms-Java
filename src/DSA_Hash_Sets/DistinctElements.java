package DSA_Hash_Sets;

/*
Problem: Count Distinct Elements in an Array

Problem Statement:
Given an integer array arr, write a Java program to count the number of distinct elements in the array using HashSet.

Example 1:
Input: arr = [1, 2, 2, 3, 4, 4, 5]
Output: 5
Explanation: The distinct elements are [1, 2, 3, 4, 5]

Input: arr = [10, 10, 10]
Output: 1
Explanation: Only one distinct element, 10

Expected Approach
Create a HashSet.
Traverse the array and add each element to the set.
Return the size of the set.


 */
import java.util.HashSet;

public class DistinctElements {
    public static int countDistinct(int[] arr) {
        // Step 1: Create a HashSet
        HashSet<Integer> set = new HashSet<>();

        // Step 2: Add element to the HashSet
        for (int num : arr) {
            set.add(num); // duplicate will be ignored automatically
        }

        // Step 3: Return the size of the HashSet
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int distinctCount = countDistinct(arr);
        System.out.println("Number of distinct element: " + distinctCount);
    }
}

/*
Explanation Step by Step

1. HashSet stores unique elements:
    When we add an element that already exists, it is ignored automatically.

2. Adding all elements:
1 → added
2 → added
2 → ignored
3 → added
4 → added
4 → ignored
5 → added
Count of distinct elements:
The set now contains [1, 2, 3, 4, 5].

.size() → 5

Dry Run Table

| Step | Array Element | HashSet After Add | Explanation         |
| ---- | ------------- | ----------------- | ------------------- |
| 1    | 1             | \[1]              | Added first element |
| 2    | 2             | \[1, 2]           | Added 2             |
| 3    | 2             | \[1, 2]           | Duplicate, ignored  |
| 4    | 3             | \[1, 2, 3]        | Added 3             |
| 5    | 4             | \[1, 2, 3, 4]     | Added 4             |
| 6    | 4             | \[1, 2, 3, 4]     | Duplicate, ignored  |
| 7    | 5             | \[1, 2, 3, 4, 5]  | Added 5             |

Final Output: 5
 */