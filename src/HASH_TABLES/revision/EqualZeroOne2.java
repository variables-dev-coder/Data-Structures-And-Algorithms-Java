package HASH_TABLES.revision;

import java.util.*;

class EqualZeroOne2 {

    public static int countSubarrays(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {

            if (num == 0) num = -1;

            sum += num;

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0};

        System.out.println(countSubarrays(nums)); // 2
    }
}
