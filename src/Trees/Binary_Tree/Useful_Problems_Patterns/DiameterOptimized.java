package Trees.Binary_Tree.Useful_Problems_Patterns;

class TreeNode2 {
    int val;
    TreeNode2 left, right;

    TreeNode2(int val) {
        this.val = val;
    }
}

class DiameterOptimized {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode2 root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode2 node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);

        DiameterOptimized d = new DiameterOptimized();
        System.out.println("Diameter: " + d.diameterOfBinaryTree(root));
    }
}

// Diameter: 3

//Diameter = leftHeight + rightHeight (for any node)
//Compute height and update diameter simultaneously → O(N)
//Helps in network path analysis, tree depth problems, and graph traversal logic building