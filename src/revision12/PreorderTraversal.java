package revision12;

class TreeNode2 {

    int data;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int data) {
        this.data = data;
    }
}

public class PreorderTraversal {

    static void preorder(TreeNode2 root) {

        if(root == null)
            return;

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode2 root = new TreeNode2(10);

        root.left = new TreeNode2(5);
        root.right = new TreeNode2(20);

        root.left.left = new TreeNode2(2);
        root.left.right = new TreeNode2(8);

        root.right.left = new TreeNode2(15);
        root.right.right = new TreeNode2(25);

        preorder(root);
    }
}
