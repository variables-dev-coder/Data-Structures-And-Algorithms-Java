package Trees.Heap_Priority_Queue.day4_Heap_PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            minHeap.add(num);

            // Keep heap size = k
            if (minHeap.size() > k) {
                minHeap.poll();  // remove smallest
            }
        }

        // Root is kth largest
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + result);
    }
}

