package revision12;

class TreeNode12 {

    int data;
    TreeNode12 left, right;

    TreeNode12(int data) {
        this.data = data;
    }
}

public class InvertBinaryTree {

    static TreeNode12 invert(TreeNode12 root) {

        if (root == null)
            return null;

        TreeNode12 temp = root.left;

        root.left = invert(root.right);

        root.right = invert(temp);

        return root;
    }

    static void preorder(TreeNode12 root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode12 root = new TreeNode12(4);

        root.left = new TreeNode12(2);
        root.right = new TreeNode12(7);

        root.left.left = new TreeNode12(1);
        root.left.right = new TreeNode12(3);

        root.right.left = new TreeNode12(6);
        root.right.right = new TreeNode12(9);

        System.out.print("Before: ");
        preorder(root);

        invert(root);

        System.out.print("\nAfter : ");
        preorder(root);
    }
}
