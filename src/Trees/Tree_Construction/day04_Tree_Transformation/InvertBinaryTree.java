package Trees.Tree_Construction.day04_Tree_Transformation;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Core logic
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // invert children
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap pointers
        root.left = right;
        root.right = left;

        return root;
    }

    // inorder print (for verification)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
            / \
           4   5
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Original Inorder: ");
        inorder(root);

        invertTree(root);

        System.out.print("\nInverted Inorder: ");
        inorder(root);
    }
}

//Original Inorder: 4 2 5 1 3
//Inverted Inorder: 3 1 5 2 4