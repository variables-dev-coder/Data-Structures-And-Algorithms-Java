package revision8;

import java.util.*;

public class SubarraySumK {

    public static void main(String[] args) {

        int[] nums = {1,1,1};

        int k = 2;

        HashMap<Integer,Integer> map =
                new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            if (map.containsKey(sum - k)) {

                count +=
                        map.get(sum - k);
            }

            map.put(
                    sum,
                    map.getOrDefault(sum, 0) + 1
            );
        }

        System.out.println(count);
    }
}
