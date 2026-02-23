package Trees.Heap_Priority_Queue.day5_HeapKthLargestSmallestElements;

import java.util.PriorityQueue;

public class KthSmallest {

    public static int findKthSmallest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(findKthSmallest(nums, k));

    }
}
