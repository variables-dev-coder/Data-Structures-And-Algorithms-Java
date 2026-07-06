package revision13;

import java.util.HashSet;

public class IntersectionOfArrays {

    public static int[] intersection(int[] nums1,
                                     int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1)
            set1.add(num);

        for (int num : nums2) {

            if (set1.contains(num))
                result.add(num);
        }

        int[] ans = new int[result.size()];

        int index = 0;

        for (int num : result) {
            ans[index++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] ans = intersection(nums1, nums2);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
