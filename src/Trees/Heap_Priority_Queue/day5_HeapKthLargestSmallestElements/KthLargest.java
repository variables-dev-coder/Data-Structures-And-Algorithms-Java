package Trees.Heap_Priority_Queue.day5_HeapKthLargestSmallestElements;

import java.util.PriorityQueue;

public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {7,10,4,3,20,15};
        int k = 3;

        System.out.println(findKthLargest(nums, k));  // 10

    }
}
