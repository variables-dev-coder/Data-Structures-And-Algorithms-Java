package Queue.Deque;

/*
Problem Statement

Given an array arr[] and a window size k, print the first negative number in every
contiguous subarray (window) of size k.
If there is no negative number in a window, print 0 for that window.

Example:

Input: arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
Output: [-1, -1, -7, -15, -15, 0]

Approach (Using Deque)
We use a Deque to store indexes of negative numbers in the current window.

Steps:
1.Process first k elements: Add indexes of negative numbers to the deque.
2.Slide the window one element at a time:
    Remove elements that are out of the window from the front of the deque.
    Add the current element’s index if it’s negative.
    The front of the deque is always the index of the first negative number in the current window.
3.If deque is empty → output 0.

 */



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeInWindow {
    public static List<Integer> firstNegative(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Process first k elements
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.addLast(i);
            }
        }

        // Process rest of the elements
        for (int i = k; i < arr.length; i++) {
            // Add result for previous window
            if (!dq.isEmpty()) {
                result.add(arr[dq.peekFirst()]);
            } else {
                result.add(0);
            }

            // Remove elements out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Add current element if it is negative
            if (arr[i] < 0) {
                dq.addLast(i);
            }
        }

        // Add result for the last window
        if (!dq.isEmpty()) {
            result.add(arr[dq.peekFirst()]);
        } else {
            result.add(0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegative(arr, k));
    }
}

/*
Dry Run :

Window 1: [12, -1, -7] → first negative = -1
Window 2: [-1, -7, 8] → first negative = -1
Window 3: [-7, 8, -15] → first negative = -7
Window 4: [8, -15, 30] → first negative = -15
Window 5: [-15, 30, 16] → first negative = -15
Window 6: [30, 16, 28] → no negative → 0

Output → [-1, -1, -7, -15, -15, 0]

 */