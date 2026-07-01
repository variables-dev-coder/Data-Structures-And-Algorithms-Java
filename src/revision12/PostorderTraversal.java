package revision12;

class TreeNode4 {

    int data;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4(int data) {
        this.data = data;
    }
}

public class PostorderTraversal {

    static void postorder(TreeNode4 root) {

        if(root == null)
            return;

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        TreeNode4 root = new TreeNode4(10);

        root.left = new TreeNode4(5);
        root.right = new TreeNode4(20);

        root.left.left = new TreeNode4(2);
        root.left.right = new TreeNode4(8);

        root.right.left = new TreeNode4(15);
        root.right.right = new TreeNode4(25);

        postorder(root);
    }
}
