package Queue.Deque;


// Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}

// [1, 2]

/*
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Explanation:
Frequency count → {1: 3, 2: 2, 3: 1}
Top 2 frequent elements → 1 and 2.

Logic
1.Count frequency of each element using a HashMap.
2.Use a Min Heap where:
    Key = element
    Priority = frequency
3.Add each (element, frequency) pair to heap.
4.If heap size > k, remove the smallest frequency.
5.Remaining heap elements are your top k frequent.

 */
