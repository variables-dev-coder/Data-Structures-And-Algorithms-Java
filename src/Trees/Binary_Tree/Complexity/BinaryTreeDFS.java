package Trees.Binary_Tree.Complexity;


// DFS Recursive (Inorder Traversal)

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDFS {
    // Recursive DFS (Inorder Traversal)
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);            // Recursive call
        System.out.print(root.val + " ");
        inorder(root.right);           // Recursive call
    }

    public static void main(String[] args) {
        // Build sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDFS bt = new BinaryTreeDFS();
        bt.inorder(root);  // Output: 4 2 5 1 3
    }
}

/*

Complexity Analysis
    Time: Each node is visited once → O(n)
    Space: Recursion stack → O(h), where h = height of tree
        Best (balanced tree): O(log n)
        Worst (skewed tree): O(n)


 */
