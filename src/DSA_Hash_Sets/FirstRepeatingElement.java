package DSA_Hash_Sets;

/*
Problem Statement:
Given an integer array arr, find the first repeating element
(the one that appears more than once and whose first occurrence is smallest).
If no element repeats, return -1.

Input: arr = [10, 5, 3, 4, 3, 5, 6]
Output: 5
Explanation: Both 5 and 3 repeat, but 5’s first occurrence comes first.

Input: arr = [1, 2, 3, 4]
Output: -1
Explanation: No element repeats.

Expected Approach
Create a HashSet.
Traverse the array:
If the element is already in the set → that’s the first repeating element, return it.
Else, add it to the set.
If no element repeats → return -1.

 */


import java.util.HashSet;

public class FirstRepeatingElement {
    public static int findFirstRepeating(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Traverse array
        for (int num : arr) {
            if (set.contains(num)) {
                return num; // First repeating element
            }
            set.add(num);
        }

        return -1; // No repeating element
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 3, 4, 3, 5, 6};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println("First repeating element: " + findFirstRepeating(arr1)); // 5
        System.out.println("First repeating element: " + findFirstRepeating(arr2)); // -1
    }
}

/*
Explanation
Create a HashSet.
Traverse elements from left to right.
If element already in set → return it immediately (because this is the first one that repeats).
Else, add it to the set.
If traversal finishes without any duplicate → return -1.

Dry Run
Input: arr = [10, 5, 3, 4, 3, 5, 6]

| Step | Element | HashSet (after step) | Duplicate? | Result                   |
| ---- | ------- | -------------------- | ---------- | ------------------------ |
| 1    | 10      | \[10]                | No         | -                        |
| 2    | 5       | \[10, 5]             | No         | -                        |
| 3    | 3       | \[10, 5, 3]          | No         | -                        |
| 4    | 4       | \[10, 5, 3, 4]       | No         | -                        |
| 5    | 3       | Already in set       | Yes        | 3 → repeating, but wait… |
| 6    | 5       | Already in set       | Yes        | 5 → repeating            |

But we need the first repeating by order of first occurrence → That’s 5 because its
first occurrence (index 1) comes before 3’s first occurrence (index 2).

Our current logic returns 3, not 5.


Corrected Approach

We need to scan from right to left and keep track of the first element that repeats.


import java.util.HashSet;

public class FirstRepeatingElement {
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