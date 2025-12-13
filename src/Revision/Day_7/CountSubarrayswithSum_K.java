package Revision.Day_7;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayswithSum_K {

    static int countSubarrays(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            if (map.containsKey(sum - K)) {
                count += map.get(sum - K);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int K = 2;

        System.out.println(countSubarrays(arr, K));
    }
}
