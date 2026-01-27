package Trees.Tree_Construction.day05_Flatten_Convert_Trees;

public class FlattenBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Returns tail of flattened subtree
    public static TreeNode flatten(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTail = flatten(root.left);
        TreeNode rightTail = flatten(root.right);

        if (leftTail != null) {
            TreeNode rightSubtree = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = rightSubtree;
        }

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }

    public static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     5
            / \     \
           3   4     6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        printList(root);
    }
}

