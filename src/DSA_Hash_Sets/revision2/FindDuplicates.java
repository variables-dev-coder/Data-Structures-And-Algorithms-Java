package DSA_Hash_Sets.revision2;

import java.util.*;

public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {

            if (set.contains(num)) {
                result.add(num);
            } else {
                set.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println("Duplicates: " + findDuplicates(nums));
    }
}
