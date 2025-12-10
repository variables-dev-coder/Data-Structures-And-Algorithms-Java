package Revision.Day_6;

/*
Given an array, check whether it is sorted in strictly non-decreasing order.
Example:
[1, 2, 3, 4] → sorted
[1, 3, 2, 4] → not sorted

1. Explanation
To check if an array is sorted:
    Compare each element with the next one.
    If arr[i] > arr[i+1] at any point → not sorted.
    If no such pair exists → sorted.

Time complexity: O(n)
Space complexity: O(1)

2. Algorithm (Step-by-Step)
    1.Loop from i = 0 to n-2
    2.If arr[i] > arr[i+1] → return false
    3.If loop finishes → return true


 */


public class CheckSortedArray {

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        boolean result = isSorted(arr);

        if (result) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is NOT sorted");
        }
    }
}

// Array is sorted

/*
Dry Run
Array: [1, 2, 3, 4, 5]

| i | arr[i] | arr[i+1] | arr[i] > arr[i+1]? | Result   |
| - | ------ | -------- | ------------------ | -------- |
| 0 | 1      | 2        | No                 | Continue |
| 1 | 2      | 3        | No                 | Continue |
| 2 | 3      | 4        | No                 | Continue |
| 3 | 4      | 5        | No                 | Continue |

Edge Cases
Empty array → sorted
Single element → sorted
Duplicate values allowed (non-decreasing)


 */