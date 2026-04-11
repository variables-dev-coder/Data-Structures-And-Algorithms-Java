package DSA_Hash_Sets.revision2;

import java.util.*;

public class IntersectionArray {
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1) set1.add(num);

        for (int num : nums2) {
            if (set1.contains(num)) result.add(num);
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) ans[i++] = num;

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};

        System.out.println(Arrays.toString(intersection(a,b)));
    }
}
