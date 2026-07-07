package revision13;

import java.util.HashSet;

public class MissingNumbers {

    public static void main(String[] args) {

        int[] nums = {1,2,4,6};

        int n = 6;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        for (int i = 1; i <= n; i++) {

            if (!set.contains(i))
                System.out.print(i + " ");
        }
    }
}
