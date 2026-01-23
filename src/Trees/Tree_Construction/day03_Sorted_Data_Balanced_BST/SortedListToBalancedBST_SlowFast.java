package Trees.Tree_Construction.day03_Sorted_Data_Balanced_BST;

public class SortedListToBalancedBST_SlowFast {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut left half
        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = (head == slow) ? null : sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    // Inorder check
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}

