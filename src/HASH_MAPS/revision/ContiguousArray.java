package HASH_MAPS.revision;

import java.util.*;

class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0};

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

        System.out.println(maxLen);
    }
}

