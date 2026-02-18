package Trees.Heap_Priority_Queue.day4_Heap_PriorityQueue;

import java.util.*;

public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(
                        (a, b) -> a.getValue() - b.getValue()
                );

        // Step 3: Maintain heap size k
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Collect result
        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        List<Integer> result = topKFrequent(nums, k);

        System.out.println("Top K Frequent Elements: " + result);
    }
}

