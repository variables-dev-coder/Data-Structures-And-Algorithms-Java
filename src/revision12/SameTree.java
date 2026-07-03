package revision12;

class TreeNode13 {

    int data;
    TreeNode13 left, right;

    TreeNode13(int data) {
        this.data = data;
    }
}

public class SameTree {

    static boolean isSame(TreeNode13 p, TreeNode13 q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.data != q.data)
            return false;

        return isSame(p.left, q.left)
                && isSame(p.right, q.right);
    }

    public static void main(String[] args) {

        TreeNode13 root1 = new TreeNode13(1);
        root1.left = new TreeNode13(2);
        root1.right = new TreeNode13(3);

        TreeNode13 root2 = new TreeNode13(1);
        root2.left = new TreeNode13(2);
        root2.right = new TreeNode13(3);

        System.out.println(isSame(root1, root2));
    }
}
