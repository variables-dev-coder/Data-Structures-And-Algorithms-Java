package revision2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Important base case


        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        int[] nums2 = {1, 2, 3};
        int k2 = 3;

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;

        System.out.println("Example 1: " + subarraySum(nums1, k1)); // 2
        System.out.println("Example 2: " + subarraySum(nums2, k2)); // 2
        System.out.println("Example 3: " + subarraySum(nums3, k3)); // 4
    }
}
