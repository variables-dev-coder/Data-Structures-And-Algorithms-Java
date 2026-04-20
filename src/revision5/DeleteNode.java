package revision5;

class DeleteNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // 1 → 2 → 3 → 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = new ListNode(3);
        head.next.next = node;
        node.next = new ListNode(4);

        deleteNode(node);

        print(head);
    }
}
