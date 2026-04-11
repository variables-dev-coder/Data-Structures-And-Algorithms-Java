package DSA_Hash_Sets.revision2;

import java.util.*;

public class SubarrayZeroSum {

    public static boolean hasZeroSum(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum == 0 || set.contains(sum)) return true;

            set.add(sum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,-3,1,6};
        System.out.println(hasZeroSum(nums));
    }
}
