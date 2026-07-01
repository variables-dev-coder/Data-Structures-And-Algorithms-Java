package revision12;

class TreeNode3 {

    int data;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int data) {
        this.data = data;
    }
}

public class InorderTraversal {

    static void inorder(TreeNode3 root) {

        if(root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode3 root = new TreeNode3(10);

        root.left = new TreeNode3(5);
        root.right = new TreeNode3(20);

        root.left.left = new TreeNode3(2);
        root.left.right = new TreeNode3(8);

        root.right.left = new TreeNode3(15);
        root.right.right = new TreeNode3(25);

        inorder(root);
    }
}
