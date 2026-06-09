package revision8;

import java.util.*;

public class ArrayIntersection {

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        HashSet<Integer> set =
                new HashSet<>();

        for (int num : nums1) {

            set.add(num);
        }

        HashSet<Integer> result =
                new HashSet<>();

        for (int num : nums2) {

            if (set.contains(num)) {

                result.add(num);
            }
        }

        System.out.println(result);
    }
}
