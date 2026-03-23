package HASH_TABLES.revision;

import java.util.*;

class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums)); // 4
    }
}
