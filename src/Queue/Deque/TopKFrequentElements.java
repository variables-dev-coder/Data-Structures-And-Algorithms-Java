package Queue.Deque;



/*

Problem Statement
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Step-by-Step Solution Approach
We can solve this using PriorityQueue (Heap):
1. Count frequency of each element
We use a HashMap<Integer, Integer> to store the frequency of each number.
2. Create a Max Heap based on frequency

We use PriorityQueue<Map.Entry<Integer,Integer>> with a custom comparator to store
the most frequent elements at the top.
3. Extract top k elements
Poll from the heap k times to get the top k frequent numbers.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max Heap (Priority Queue)
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        // Step 3: Extract top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}

/*
Dry Run
Input:
nums = [1,1,1,2,2,3], k = 2

Step 1: Count frequency

freqMap:
1 -> 3
2 -> 2
3 -> 1

Step 2: Max Heap based on frequency
Heap contains:
(1, 3)   // most frequent
(2, 2)
(3, 1)

Step 3: Extract top k
Poll 1 → (1, 3) → result = [1]
Poll 2 → (2, 2) → result = [1, 2]
Output: [1, 2]

Time Complexity:
Building freqMap → O(N)
Adding to heap → O(N log N)
Extracting k → O(k log N)
Overall: O(N log N)

Space Complexity: O(N) (for HashMap & Heap)

 */