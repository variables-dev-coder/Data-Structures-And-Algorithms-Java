package revision10;

import java.util.HashMap;

public class ContainsDuplicateII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 4, 3, 5};
        int k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                if (i - map.get(nums[i]) <= k) {
                    System.out.println(true);
                    return;
                }
            }

            map.put(nums[i], i);
        }

        System.out.println(false);
    }
}
