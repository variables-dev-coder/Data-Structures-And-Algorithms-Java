package Queue.PriorityQueue;


/*
Problem Statement:
Given an integer array nums and an integer k, return the k-th largest element in the array.

Note: It is the k-th largest in sorted order, not the k-th distinct element.

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Explanation: Sorted array = [6,5,4,3,2,1], 2nd largest is 5.

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Logic & Steps
We use a Min Heap of size k:
Keep adding elements to the heap.
If heap size > k, remove the smallest (top element in Min Heap).
At the end, heap’s top = k-th largest.

 */


import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num); // Add element to heap

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the heap is the k-th largest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("Kth largest element: " + findKthLargest(nums, k));
    }
}

/*
Why Priority Queue?
We can solve it in O(n log k) using a Min Heap:
Keep pushing elements into the min heap.
If heap size > k, remove the smallest.
The top of the heap will be the k-th largest.


| Step | Element | Heap (min → max)                | Action          |
| ---- | ------- | ------------------------------- | --------------- |
| 1    | 3       | \[3]                            | add             |
| 2    | 2       | \[2, 3]                         | add             |
| 3    | 1       | \[1, 3, 2] → remove 1 → \[2, 3] | remove smallest |
| 4    | 5       | \[2, 3, 5] → remove 2 → \[3, 5] | remove smallest |
| 5    | 6       | \[3, 5, 6] → remove 3 → \[5, 6] | remove smallest |
| 6    | 4       | \[4, 6, 5] → remove 4 → \[5, 6] | remove smallest |


 */