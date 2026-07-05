package revision12;

class TreeNode19 {

    int data;
    TreeNode19 left, right;

    TreeNode19(int data) {
        this.data = data;
    }
}

public class LowestCommonAncestor {

    static TreeNode19 lca(TreeNode19 root,
                          TreeNode19 p,
                          TreeNode19 q) {

        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode19 left = lca(root.left, p, q);
        TreeNode19 right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {

        TreeNode19 root = new TreeNode19(3);

        root.left = new TreeNode19(5);
        root.right = new TreeNode19(1);

        root.left.left = new TreeNode19(6);
        root.left.right = new TreeNode19(2);

        root.right.left = new TreeNode19(0);
        root.right.right = new TreeNode19(8);

        root.left.right.left = new TreeNode19(7);
        root.left.right.right = new TreeNode19(4);

        TreeNode19 ans = lca(root,
                root.left,
                root.right);

        System.out.println(ans.data);
    }
}
