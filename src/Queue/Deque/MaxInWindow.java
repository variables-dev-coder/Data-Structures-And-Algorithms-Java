package Queue.Deque;


/*
Problem Statement

Given an array of integers and a window size k,

Find the minimum or maximum element in each sliding window.
Use a Deque to optimize the solution to O(n) time.

Example

Input:

arr = [4, 2, 12, 3, 5, 8, 1]
k = 3

Output (Max in each window):

[12, 12, 12, 8, 8]

Idea

Use a monotonic deque:
For max: Keep elements in decreasing order in the deque.
For min: Keep elements in increasing order.
Remove elements from back if they are smaller than the current element (for max).
Remove elements from front if they are outside the window.


 */


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindow {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>(); // store indices

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Window is ready
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 12, 3, 5, 8, 1};
        int k = 3;
        System.out.println(maxSlidingWindow(arr, k));
    }
}

/*
Dry Run (for arr = [4, 2, 12, 3, 5, 8, 1], k=3)
1.Window [4, 2, 12] → max = 12
2.Window [2, 12, 3] → max = 12
3.Window [12, 3, 5] → max = 12
4.Window [3, 5, 8] → max = 8
5.Window [5, 8, 1] → max = 8

 */