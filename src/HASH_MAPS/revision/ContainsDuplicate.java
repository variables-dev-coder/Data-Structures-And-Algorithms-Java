package HASH_MAPS.revision;

import java.util.*;

class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}

