package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2)); // 5
    }
}
