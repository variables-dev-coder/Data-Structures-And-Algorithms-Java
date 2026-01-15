package HASH_MAPS.revision;

import java.util.*;

class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > nums.length / 2) {
                System.out.println(n);
                return;
            }
        }
    }
}

