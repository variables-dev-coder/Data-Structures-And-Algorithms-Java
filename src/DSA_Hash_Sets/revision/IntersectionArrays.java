package DSA_Hash_Sets.revision;

import java.util.*;

public class IntersectionArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int n : nums1) set.add(n);
        for (int n : nums2)
            if (set.contains(n)) result.add(n);

        System.out.println(result);
    }
}

