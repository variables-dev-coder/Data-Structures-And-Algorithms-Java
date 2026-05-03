package Trees.revisionHeapPriorityQueue;

import java.util.*;

public class HeapBasic {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(2);

        System.out.println("Heap (Min First):");

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
