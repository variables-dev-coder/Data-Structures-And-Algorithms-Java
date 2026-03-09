package Trees.Heap_Priority_Queue.revision;

import java.util.*;

public class SmallestRange {

    static class Node {
        int value;
        int list;
        int index;

        Node(int v, int l, int i) {
            value = v;
            list = l;
            index = i;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>((a,b)->a.value-b.value);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {

            int val = nums.get(i).get(0);

            minHeap.add(new Node(val,i,0));

            max = Math.max(max,val);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while (true) {

            Node cur = minHeap.poll();

            int min = cur.value;

            if (max - min < rangeEnd - rangeStart) {

                rangeStart = min;
                rangeEnd = max;
            }

            if (cur.index + 1 == nums.get(cur.list).size())
                break;

            int nextVal =
                    nums.get(cur.list).get(cur.index+1);

            max = Math.max(max,nextVal);

            minHeap.add(
                    new Node(nextVal,
                            cur.list,
                            cur.index+1)
            );
        }

        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        int[] res = smallestRange(nums);

        System.out.println(Arrays.toString(res));
    }
}
