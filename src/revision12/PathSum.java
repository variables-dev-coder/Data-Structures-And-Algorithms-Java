package revision12;

class TreeNode16 {

    int data;
    TreeNode16 left;
    TreeNode16 right;

    TreeNode16(int data) {
        this.data = data;
    }
}

public class PathSum {

    static boolean hasPathSum(TreeNode16 root, int target) {

        if (root == null)
            return false;

        if (root.left == null &&
                root.right == null)
            return target == root.data;

        return hasPathSum(root.left, target - root.data)
                ||
                hasPathSum(root.right, target - root.data);
    }

    public static void main(String[] args) {

        TreeNode16 root = new TreeNode16(5);

        root.left = new TreeNode16(4);
        root.right = new TreeNode16(8);

        root.left.left = new TreeNode16(11);

        root.left.left.left = new TreeNode16(7);
        root.left.left.right = new TreeNode16(2);

        root.right.left = new TreeNode16(13);
        root.right.right = new TreeNode16(4);

        System.out.println(
                hasPathSum(root,22)
        );
    }
}
