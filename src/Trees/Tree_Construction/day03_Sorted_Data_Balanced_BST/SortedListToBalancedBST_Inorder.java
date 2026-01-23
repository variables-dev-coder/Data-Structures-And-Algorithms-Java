package Trees.Tree_Construction.day03_Sorted_Data_Balanced_BST;

public class SortedListToBalancedBST_Inorder {

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

    static ListNode current;

    public static TreeNode sortedListToBST(ListNode head) {
        current = head;
        int size = getSize(head);
        return build(0, size - 1);
    }

    private static int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private static TreeNode build(int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode left = build(start, mid - 1);

        TreeNode root = new TreeNode(current.val);
        current = current.next;

        root.left = left;
        root.right = build(mid + 1, end);

        return root;
    }

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

