package Trees.Tree_Construction.day05_Flatten_Convert_Trees;

public class BinaryTreeToDLL {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode head = null;
    static TreeNode prev = null;

    public static void convertToDLL(TreeNode root) {
        if (root == null) return;

        convertToDLL(root.left);

        if (prev == null) {
            head = root; // first node
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertToDLL(root.right);
    }

    public static void printDLL(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        /*
                4
              /   \
             2     5
            / \
           1   3
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        convertToDLL(root);
        printDLL(head);
    }
}

