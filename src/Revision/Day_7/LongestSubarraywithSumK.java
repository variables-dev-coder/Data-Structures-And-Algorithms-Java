package Revision.Day_7;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraywithSumK {

    static int longestSubarray(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == K) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - K)) {
                maxLen = Math.max(maxLen, i - map.get(sum - K));
            }

            // Store only first occurrence
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int K = 15;

        System.out.println(longestSubarray(arr, K));
    }
}
