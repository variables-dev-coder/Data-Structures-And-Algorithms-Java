package Queue.PriorityQueue;


/*
Problem Statement:
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Approach & Logic
Count Frequencies – Use HashMap<Integer, Integer> to store each element and its frequency.
Use Min Heap (PriorityQueue) – Store elements in a min-heap based on frequency.
Heap Size Control – If heap size > k, remove the smallest frequency element.
Extract Elements – After processing, extract the heap elements for the result.
 */


import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Step 3: Keep top k frequent in the heap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest frequency
            }
        }

        // Step 4: Build result
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k))); // Output: [1, 2]
    }
}

/*
Dry Run Example
nums = [1, 1, 1, 2, 2, 3], k = 2
Frequency Map: {1=3, 2=2, 3=1}
Add (1,3) → Heap size = 1
Add (2,2) → Heap size = 2
Add (3,1) → Heap size = 3 → remove (3,1)
Heap now: [(2,2), (1,3)]
Extract: [1, 2]


Explanation:
Number 1 appears 3 times
Number 2 appears 2 times
Number 3 appears 1 time
Top 2 most frequent are [1, 2]


Why Priority Queue?
We use a Priority Queue (Max Heap or Min Heap) to efficiently get the k most frequent numbers.
Step 1: Count frequency of each number using HashMap
Step 2: Use a Priority Queue to keep track of top k elements based on frequency
Step 3: Extract the top k from the queue

 */