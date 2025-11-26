package Trees.Binary_Tree.Revision03;

public class Diameter {
    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private static int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root)); // 3
    }
}

