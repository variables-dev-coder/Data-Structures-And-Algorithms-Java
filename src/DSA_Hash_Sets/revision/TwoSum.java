package DSA_Hash_Sets.revision;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                System.out.println(map.get(need) + ", " + i);
                return;
            }
            map.put(nums[i], i);
        }
    }
}

