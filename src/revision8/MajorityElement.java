package revision8;

import java.util.HashMap;

public class MajorityElement {

    static int majorityElement(int[] arr) {

        HashMap<Integer, Integer> map =
                new HashMap<>();

        int n = arr.length;

        for (int num : arr) {

            map.put(
                    num,
                    map.getOrDefault(num, 0) + 1
            );

            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {
                2, 2, 1, 1, 1, 2, 2
        };

        System.out.println(
                majorityElement(arr)
        );
    }
}
