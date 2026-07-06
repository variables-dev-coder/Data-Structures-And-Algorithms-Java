package revision13;

import java.util.HashSet;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (window.contains(nums[i]))
                return true;

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println(
                containsNearbyDuplicate(nums, 3)
        );
    }
}
