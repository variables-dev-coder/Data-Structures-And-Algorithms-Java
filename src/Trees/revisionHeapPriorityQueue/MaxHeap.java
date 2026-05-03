package Trees.revisionHeapPriorityQueue;

import java.util.*;

public class MaxHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(2);

        System.out.println("Heap (Max First):");

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
