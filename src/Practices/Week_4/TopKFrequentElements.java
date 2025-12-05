package Practices.Week_4;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap (frequency, value)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        // Step 3: Build heap
        for (int num : map.keySet()) {
            pq.add(new int[]{map.get(num), num});

            if (pq.size() > k) pq.poll();
        }

        // Step 4: Extract result
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll()[1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] res = topKFrequent(nums, k);

        System.out.print("Top K frequent: ");
        for (int x : res) System.out.print(x + " ");
    }
}

// Top K frequent: 2 1 