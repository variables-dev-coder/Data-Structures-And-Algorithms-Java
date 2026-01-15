package HASH_MAPS.revision;

import java.util.*;

class IntersectionArrayII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int n : nums1)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (int n : nums2) {
            if (map.getOrDefault(n, 0) > 0) {
                result.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        System.out.println(result);
    }
}

