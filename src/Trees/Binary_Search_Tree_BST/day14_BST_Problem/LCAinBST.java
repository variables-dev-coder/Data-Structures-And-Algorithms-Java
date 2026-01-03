package Trees.Binary_Search_Tree_BST.day14_BST_Problem;

class TreeNode2 {
    int val;
    TreeNode2 left, right;

    TreeNode2(int val) {
        this.val = val;
    }
}

public class LCAinBST {

    public static TreeNode2 lca(TreeNode2 root, int p, int q) {

        while (root != null) {
            if (p < root.val && q < root.val)
                root = root.left;
            else if (p > root.val && q > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(50);
        root.left = new TreeNode2(30);
        root.right = new TreeNode2(70);
        root.left.left = new TreeNode2(20);
        root.left.right = new TreeNode2(40);

        System.out.println(lca(root, 20, 40).val); // 30
    }
}

