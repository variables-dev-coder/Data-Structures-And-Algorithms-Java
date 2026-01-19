package HASH_TABLES.revision;

import java.util.*;

public class EqualZeroOneDemo {

    public static int longestSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 1, 0};
        System.out.println(longestSubarray(arr));
    }
}

