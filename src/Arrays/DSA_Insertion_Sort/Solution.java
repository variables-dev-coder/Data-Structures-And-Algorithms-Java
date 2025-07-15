package Arrays.DSA_Insertion_Sort;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // Dummy node to build sorted list
        ListNode curr = head; // Current node to insert

        while (curr != null) {
            ListNode prev = dummy;
            ListNode next = curr.next; // Save next node

            // Find insertion point
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr
            curr.next = prev.next;
            prev.next = curr;

            curr = next; // Move to next unsorted node
        }

        return dummy.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        ListNode sorted = new Solution().insertionSortList(head);

        System.out.println("Sorted List:");
        printList(sorted);
    }
}