package Trees.Heap_Priority_Queue.day4_Heap_PriorityQueue;

import java.util.*;

public class SlidingWindowMax {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        // Max Heap based on value
        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.value - a.value
                );

        for (int i = 0; i < nums.length; i++) {

            maxHeap.add(new Pair(nums[i], i));

            // Remove elements outside window
            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            // Start recording result when window is full
            if (i >= k - 1) {
                result.add(maxHeap.peek().value);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Sliding Window Maximum: " + result);
    }
}

