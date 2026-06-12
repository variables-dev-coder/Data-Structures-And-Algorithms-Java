package revision10;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 4, 3, 5};

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                System.out.println(true);
                return;
            }

            set.add(num);
        }

        System.out.println(false);
    }
}
