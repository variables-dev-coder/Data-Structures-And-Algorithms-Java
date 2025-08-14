package Queue.Deque;


/*
Problem 9: First Occurrence in Array

Description:
You are given an array and a target value. Your task is to find the first index where the target appears.
If the target is not present, return -1.

ex
arr = [4, 2, 7, 2, 5, 2]
target = 2

1

ex
arr = [10, 20, 30, 40]
target = 50

-1

Explanation: 50 is not found in the array.

Logic Explanation
1.Start from index 0.
2.Compare each element with the target.
3.The first match found → return its index immediately.
4.If loop finishes without finding → return -1.

 */

public class FirstOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return first index found
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 2, 5, 2};
        int target = 2;

        int index = findFirstOccurrence(arr, target);

        if (index != -1) {
            System.out.println("First occurrence found at index: " + index);
        } else {
            System.out.println("Target not found in the array");
        }
    }
}

// First occurrence found at index: 1