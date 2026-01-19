package DSA_Hash_Sets.revision;

import java.util.*;

public class IntersectionDemo {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n)) {
                result.add(n);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int n : result) {
            ans[i++] = n;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};

        System.out.println(Arrays.toString(intersection(a, b)));
    }
}

