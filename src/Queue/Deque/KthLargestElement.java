package Queue.Deque;

// Given an integer array nums and an integer k, return the kth largest element in the array.
// The Kth largest element means the element that would appear in position K if the
// array were sorted in descending order.

//nums = [3,2,1,5,6,4]
       // k = 2
// 5

//Explanation:
//Sorted in descending order: [6, 5, 4, 3, 2, 1]
//The 2nd largest is 5.


import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest
            }
        }

        return minHeap.peek(); // Kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + findKthLargest(nums, k));
    }
}

// Kth largest element is: 5

/*

Step-by-Step Logic Using Min-Heap
We can solve it using a Min-Heap of size k:

1. Why Min-Heap?
    A Min-Heap always keeps the smallest element at the top.
    If we maintain a heap of size k, then the smallest element in that heap will be the kth largest overall.

2. Algorithm:
    Create an empty Min-Heap.
    Iterate over each number in the array:
        Push the number into the heap.
        If heap size exceeds k, pop the smallest element.
    After processing all numbers, the top of the heap will be the kth largest.

3.Time Complexity:
    Heap insertion/removal → O(log k)
    Doing this for n elements → O(n log k)
    Much better than sorting the entire array (O(n log n)).

 Dry Run
Example: nums = [3,2,1,5,6,4], k = 2

| Step | Num | Heap After Push | Action                   |
| ---- | --- | --------------- | ------------------------ |
| 1    | 3   | \[3]            | Size ≤ k                 |
| 2    | 2   | \[2, 3]         | Size ≤ k                 |
| 3    | 1   | \[1, 3, 2]      | Size > k → pop → \[2, 3] |
| 4    | 5   | \[2, 3, 5]      | Size > k → pop → \[3, 5] |
| 5    | 6   | \[3, 5, 6]      | Size > k → pop → \[5, 6] |
| 6    | 4   | \[4, 6, 5]      | Size > k → pop → \[5, 6] |

 */