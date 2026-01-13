package DSA_Hash_Sets.revision;

import java.util.*;

public class LongestSubarraySumK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, -10};
        int k = 15;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }

        System.out.println(maxLen);
    }
}

