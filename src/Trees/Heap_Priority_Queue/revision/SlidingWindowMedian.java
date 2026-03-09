package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class SlidingWindowMedian {

    public static double[] medianSlidingWindow(int[] nums, int k) {

        List<Double> result = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {

            PriorityQueue<Integer> maxHeap =
                    new PriorityQueue<>(Collections.reverseOrder());

            PriorityQueue<Integer> minHeap =
                    new PriorityQueue<>();

            for (int j = i; j < i + k; j++) {

                maxHeap.add(nums[j]);
                minHeap.add(maxHeap.poll());

                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
            }

            if (k % 2 == 1)
                result.add((double) maxHeap.peek());
            else
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
        }

        double[] ans = new double[result.size()];

        for (int i = 0; i < result.size(); i++)
            ans[i] = result.get(i);

        return ans;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(
                medianSlidingWindow(nums, k)));
    }
}
