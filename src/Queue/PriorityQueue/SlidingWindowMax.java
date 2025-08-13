package Queue.PriorityQueue;


/*
Problem Statement
You are given an integer array nums and an integer k.
You need to find the maximum value in every sliding window of size k.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation:
Windows are:
[1, 3, -1] → max = 3
[3, -1, -3] → max = 3
[-1, -3, 5] → max = 5
[-3, 5, 3] → max = 5
[5, 3, 6] → max = 6
[3, 6, 7] → max = 7

 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // value, index
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            // Add current element to heap
            maxHeap.offer(new int[]{nums[i], i});

            // Remove elements out of the current window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // If window is fully formed, add max to result
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
//[3, 3, 5, 5, 6, 7]

/*
Dry Run for Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
i=0 → heap=[(1,0)]
i=1 → heap=[(3,1),(1,0)]
i=2 → heap=[(3,1),(1,0),(-1,2)] → window max = 3
i=3 → remove index 0 → heap=[(3,1),(-1,2),(-3,3)] → window max = 3
i=4 → heap=[(5,4),(3,1),(3,3),(-1,2)] → remove old → max=5
i=5 → heap=[(5,4),(3,5),(3,3)] → max=5
i=6 → heap=[(6,6),(5,4),(3,5)] → max=6
i=7 → heap=[(7,7),(6,6),(3,5)] → max=7
Output: [3, 3, 5, 5, 6, 7]

 */