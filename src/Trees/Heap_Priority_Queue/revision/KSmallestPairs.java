package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class KSmallestPairs {

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1,
                                                     int[] nums2,
                                                     int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0)
            return result;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a,b) ->
                        (nums1[a.i] + nums2[a.j]) -
                                (nums1[b.i] + nums2[b.j]));

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new Pair(i,0));
        }

        while (k-- > 0 && !pq.isEmpty()) {

            Pair cur = pq.poll();

            result.add(Arrays.asList(
                    nums1[cur.i],
                    nums2[cur.j]
            ));

            if (cur.j + 1 < nums2.length) {
                pq.add(new Pair(cur.i, cur.j + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int nums1[] = {1,7,11};
        int nums2[] = {2,4,6};

        System.out.println(
                kSmallestPairs(nums1, nums2, 3)
        );
    }
}
