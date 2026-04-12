package revision5;

import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1,1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);
    }
}
