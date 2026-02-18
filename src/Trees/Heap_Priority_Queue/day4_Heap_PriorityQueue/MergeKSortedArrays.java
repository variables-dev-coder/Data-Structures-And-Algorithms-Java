package Trees.Heap_Priority_Queue.day4_Heap_PriorityQueue;

import java.util.*;

class Node {
    int value;
    int arrayIndex;
    int elementIndex;

    Node(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class MergeKSortedArrays {

    public static List<Integer> merge(int[][] arrays) {

        List<Integer> result = new ArrayList<>();

        // Min Heap based on value
        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(
                        (a, b) -> a.value - b.value
                );

        // Insert first element of each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()) {

            Node current = minHeap.poll();
            result.add(current.value);

            int nextIndex = current.elementIndex + 1;

            // Insert next element from same array
            if (nextIndex < arrays[current.arrayIndex].length) {
                minHeap.add(
                        new Node(
                                arrays[current.arrayIndex][nextIndex],
                                current.arrayIndex,
                                nextIndex
                        )
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] arrays = {
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };

        List<Integer> merged = merge(arrays);

        System.out.println("Merged Array: " + merged);
    }
}

