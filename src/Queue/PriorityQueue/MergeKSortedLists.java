package Queue.PriorityQueue;


/*

Problem:
You are given k linked lists, each sorted in ascending order.
Merge all the linked lists into one sorted linked list and return it.

Input:
lists = [
  1 -> 4 -> 5,
  1 -> 3 -> 4,
  2 -> 6
]

Output:
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

Constraints:
Number of linked lists k can be large (up to 10⁴ in some cases).
Total nodes can also be large.
Efficient solution should use PriorityQueue (Min Heap) to pick the smallest node among all lists efficiently.

Approach Using PriorityQueue
We use a Min Heap to always get the smallest element among the k lists efficiently.

Steps:
1.Create a PriorityQueue that compares nodes by their val.
2.Add the head node of each linked list into the queue (if not null).
3.While the queue is not empty:
    Extract (poll) the smallest node from the heap.
    Append it to the result list.
    If that node has a next, push it into the queue (because the next node is the next smallest from that list).
4.Return the merged linked list starting from dummy.next.


 */

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add first node of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2: Process until heap is empty
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example Input
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = { l1, l2, l3 };

        ListNode merged = mergeKLists(lists);

        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}

// 1 1 2 3 4 4 5 6

/*
l1: 1 -> 4 -> 5
l2: 1 -> 3 -> 4
l3: 2 -> 6

Heap after initialization: [1(l1), 1(l2), 2(l3)]
Poll 1(l1) → add 4(l1) → Result: 1
Poll 1(l2) → add 3(l2) → Result: 1 -> 1
Poll 2(l3) → add 6(l3) → Result: 1 -> 1 -> 2
Poll 3(l2) → add 4(l2) → Result: 1 -> 1 -> 2 -> 3
Poll 4(l1) → add 5(l1) → Result: 1 -> 1 -> 2 -> 3 -> 4
Poll 4(l2) → nothing to add → Result: 1 -> 1 -> 2 -> 3 -> 4 -> 4
Poll 5(l1) → nothing to add → Result: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5
Poll 6(l3) → nothing to add → Result: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

Final Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 */