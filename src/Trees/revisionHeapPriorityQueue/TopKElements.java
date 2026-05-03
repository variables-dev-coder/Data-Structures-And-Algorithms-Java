package Trees.revisionHeapPriorityQueue;

import java.util.*;

public class TopKElements {

    public static List<Integer> topK(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 12, 2, 11};
        int k = 3;

        System.out.println("Top K: " + topK(arr, k));
    }
}
