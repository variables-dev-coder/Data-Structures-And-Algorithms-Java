package revision5;

class IntersectionLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1; // intersection node or null
    }

    public static void main(String[] args) {

        // Common part: 8 → 10
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A: 3 → 7 → 8 → 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // List B: 99 → 8 → 10
        ListNode headB = new ListNode(99);
        headB.next = common;

        ListNode res = getIntersectionNode(headA, headB);

        System.out.println("Intersection: " + (res != null ? res.val : "None"));
    }
}
