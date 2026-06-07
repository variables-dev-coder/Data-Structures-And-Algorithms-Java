package revision8;

import java.util.*;

public class TopKFrequent {

    static int[] topKFrequent(
            int[] arr,
            int k) {

        HashMap<Integer, Integer> map =
                new HashMap<>();

        // frequency count
        for (int num : arr) {

            map.put(
                    num,
                    map.getOrDefault(num, 0) + 1
            );
        }

        // max heap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                map.get(b) - map.get(a)
                );

        pq.addAll(map.keySet());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {

            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr =
                {1,1,1,2,2,3};

        int k = 2;

        System.out.println(
                Arrays.toString(
                        topKFrequent(arr, k)
                )
        );
    }
}
