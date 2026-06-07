package revision8;

import java.util.HashMap;

public class FrequencyCount {

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 2, 1};

        HashMap<Integer, Integer> map =
                new HashMap<>();

        for (int num : arr) {

            map.put(
                    num,
                    map.getOrDefault(num, 0) + 1
            );
        }

        for (Integer key : map.keySet()) {

            System.out.println(
                    key + " -> " + map.get(key)
            );
        }
    }
}
