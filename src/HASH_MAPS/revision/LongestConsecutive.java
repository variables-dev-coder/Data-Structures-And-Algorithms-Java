package HASH_MAPS.revision;

import java.util.*;

class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int longest = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {   // start of sequence
                int curr = n;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }

        System.out.println(longest);
    }
}

